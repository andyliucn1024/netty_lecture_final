package com.huigod.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioTest12 {

  public static void main(String[] args) throws Exception {
    int[] ports = new int[5];

    ports[0] = 5000;
    ports[1] = 5001;
    ports[2] = 5002;
    ports[3] = 5003;
    ports[4] = 5004;

    Selector selector = Selector.open();

    for (int port : ports) {
      ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
      serverSocketChannel.configureBlocking(false);
      ServerSocket serverSocket = serverSocketChannel.socket();
      serverSocket.bind(new InetSocketAddress("localhost", port));

      serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

      System.out.println("监听端口： " + port);
    }

    while (true) {
      //返回key集合个数，可能为0，其中key所对应的channel一定是准备好IO操作的channel
      //该方法会阻塞直到至少有一个channel准备就绪
      int channels = selector.select();
      System.out.println("channels: " + channels);
      //返回selected-key集合，该集合中的元素可以移除，但是不能直接添加
      Set<SelectionKey> selectionKeys = selector.selectedKeys();
      Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
      while (keyIterator.hasNext()) {
        SelectionKey selectionKey = keyIterator.next();
        //channel可连接事件发生
        if (selectionKey.isAcceptable()) {
          ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
          SocketChannel socketChannel = serverSocketChannel.accept();
          socketChannel.configureBlocking(false);
          socketChannel.register(selector, SelectionKey.OP_READ);
          System.out.println("获得客户端连接： " + socketChannel);
        } else if (selectionKey.isReadable()) {
          //channel可读事件发生
          SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
          int bytesRead = 0;
          ByteBuffer byteBuffer = ByteBuffer.allocate(512);
          while (true) {
            byteBuffer.clear();

            int read = socketChannel.read(byteBuffer);
            if (read <= 0) {
              if (read == -1) {
                socketChannel.close();
              }
              break;
            }
            byteBuffer.flip();

            socketChannel.write(byteBuffer);
            bytesRead += read;
          }
          System.out.println("读取： " + bytesRead + ",来自于：" + socketChannel);
        }
        keyIterator.remove();

      }
    }
  }

}
