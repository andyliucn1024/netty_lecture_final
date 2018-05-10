package com.huigod.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIOServer {

  public static void main(String[] args) throws Exception {
    InetSocketAddress address = new InetSocketAddress(8899);

    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    ServerSocket serverSocket = serverSocketChannel.socket();
    //当一个TCP连接被关闭之后，可能会在一段时间处于一个超时状态（TIME_WAIT）
    //应用无法绑定到这种超时状态的连接对应的端口号地址上
    //启用SO_ADDRESS属性之后，允许应用绑定到处于一个超时状态的链接
    serverSocket.setReuseAddress(true);
    serverSocket.bind(address);

    ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

    while (true) {
      SocketChannel socketChannel = serverSocketChannel.accept();
      //默认就是阻塞
      socketChannel.configureBlocking(true);

      int readCount = 0;

      while (-1 != readCount) {
        try {
          readCount = socketChannel.read(byteBuffer);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        byteBuffer.rewind();
      }

    }
  }

}
