package com.huigod.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class NioServer {

  private static Map<String, SocketChannel> clients = new HashMap<>();

  public static void main(String[] args) throws Exception {
    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    //设置成异步
    serverSocketChannel.configureBlocking(false);

    ServerSocket serverSocket = serverSocketChannel.socket();
    serverSocket.bind(new InetSocketAddress("localhost", 8899));

    Selector selector = Selector.open();
    //将对应的channel注册到selector上，并监听连接的事件
    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

    while (true) {
      //会阻塞，直到至少有一个channel有相应的事件发生
      selector.select();

      Set<SelectionKey> selectionKeySet = selector.selectedKeys();
      Iterator<SelectionKey> selectionKeys = selectionKeySet.iterator();

      while (selectionKeys.hasNext()) {
        SelectionKey selectionKey = selectionKeys.next();
        if (selectionKey.isAcceptable()) {
          ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
          SocketChannel client = server.accept();
          client.configureBlocking(false);
          client.register(selector, SelectionKey.OP_READ);

          String key = "【" + UUID.randomUUID().toString() + "】";
          clients.put(key, client);
        } else if (selectionKey.isReadable()) {

          SocketChannel client = (SocketChannel) selectionKey.channel();

          ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
          Charset charset = Charset.forName("utf-8");

          while (true) {
            byteBuffer.clear();

            int read = client.read(byteBuffer);
            if (read <= 0) {
              //当客户端主动关闭的时候会返回-1，因此在这里关闭对应的channel
              if (read == -1) {
                client.close();
                Iterator<Entry<String, SocketChannel>> iterableClients = clients.entrySet()
                    .iterator();
                while (iterableClients.hasNext()) {
                  Entry<String, SocketChannel> iterableClient = iterableClients.next();
                  if (iterableClient.getValue() == client) {
                    iterableClients.remove();
                    break;
                  }
                }
              }
              break;
            }

            byteBuffer.flip();

            String receivedMessage = String.valueOf(charset.decode(byteBuffer).array());
            System.out.println(client + ": " + receivedMessage);

            String sendKey = clients.entrySet().stream()
                .filter(clientSocketChannel ->
                    clientSocketChannel.getValue() == client
                ).findFirst().map(Entry::getKey).orElse(null);

            clients.entrySet().forEach(entry -> {
              SocketChannel socketChannel = entry.getValue();

              byteBuffer.clear();
              byteBuffer.put((sendKey + ": " + receivedMessage).getBytes());
              byteBuffer.flip();

              try {
                socketChannel.write(byteBuffer);
              } catch (IOException e) {
                e.printStackTrace();
              }
            });
          }
        }
        selectionKeys.remove();
      }
    }
  }
}
