package com.huigod.nio;

import java.nio.ByteBuffer;

public class NioTest7 {

  public static void main(String[] args) {
    ByteBuffer buffer = ByteBuffer.allocate(10);
    System.out.println(buffer.getClass());

    for(int i=0;i<buffer.capacity();i++) {
      buffer.put((byte) i);
    }

    ByteBuffer readonlyBuffer = buffer.asReadOnlyBuffer();

    System.out.println(readonlyBuffer.getClass());

    readonlyBuffer.position(0);

    readonlyBuffer.put((byte) 2);
  }

}
