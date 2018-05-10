package com.huigod.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioClient {

  public static void main(String[] args) throws Exception {
    SocketChannel socketChannel = SocketChannel.open();
    socketChannel.configureBlocking(false);

    Selector selector = Selector.open();
    socketChannel.register(selector, SelectionKey.OP_CONNECT);
    socketChannel.connect(new InetSocketAddress("localhost", 8899));

    while (true) {
      selector.select();

      Set<SelectionKey> selectionKeySet = selector.selectedKeys();

      Charset charset = Charset.forName("utf-8");
      selectionKeySet.forEach(selectionKey -> {
        try {
          if (selectionKey.isConnectable()) {
            SocketChannel client = (SocketChannel) selectionKey.channel();
            //完成连接
            if (client.isConnectionPending()) {

              client.finishConnect();
              ByteBuffer writerBuffer = ByteBuffer.allocate(1024);

              writerBuffer.put((LocalDateTime.now() + " 连接成功").getBytes());
              writerBuffer.flip();
              client.write(writerBuffer);
              //线程池来不断地处理输入的信息
              ExecutorService executorService = Executors
                  .newSingleThreadExecutor(Executors.defaultThreadFactory());
              executorService.submit(() -> {
                while (true) {
                  try {
                    writerBuffer.clear();

                    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                    String sendMessage = input.readLine();
                    writerBuffer.put(sendMessage.getBytes());

                    writerBuffer.flip();
                    client.write(writerBuffer);
                  } catch (Exception ex) {
                    ex.printStackTrace();
                  }
                }
              });
            }

            client.register(selector, SelectionKey.OP_READ);
          } else if (selectionKey.isReadable()) {
            SocketChannel client = (SocketChannel) selectionKey.channel();

            ByteBuffer readBuffer = ByteBuffer.allocate(1024);

            while (true) {
              readBuffer.clear();
              int read = client.read(readBuffer);
              if (read <= 0) {
                if (read == -1) {
                  client.close();
                }
                break;
              }
              readBuffer.flip();
              System.out.println(String.valueOf(charset.decode(readBuffer).array()));
            }
          }
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      });
      selectionKeySet.clear();
    }
  }

}
