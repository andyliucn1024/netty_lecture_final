package com.huigod.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest8 {

  public static void main(String[] args) throws Exception{
    FileInputStream inputStream = new FileInputStream("input2.txt");
    FileOutputStream outputStream = new FileOutputStream("output2.txt");

    FileChannel inputChannel = inputStream.getChannel();
    FileChannel outputChannel = outputStream.getChannel();

    ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

    while (true) {
      buffer.clear();
      int read = inputChannel.read(buffer);
      if (-1 == read) {
        break;
      }
      buffer.flip();
      outputChannel.write(buffer);
    }

    inputChannel.close();
    outputChannel.close();
  }

}
