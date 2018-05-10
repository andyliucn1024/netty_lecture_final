package com.huigod.nio;

import java.nio.ByteBuffer;

public class NioTest6 {

  public static void main(String[] args) {

    ByteBuffer buffer = ByteBuffer.allocate(10);

    for (int i = 0; i < buffer.capacity(); i++) {
      buffer.put((byte) i);
    }

    buffer.position(2);
    buffer.limit(6);

    ByteBuffer sliceBuffer = buffer.slice();
    System.out.println("sliceBuffer.position: " + sliceBuffer.position());
    System.out.println("sliceBuffer.limit: " + sliceBuffer.limit());
    System.out.println("sliceBuffer.capacity: " + sliceBuffer.capacity());

    for (int i = 0; i < sliceBuffer.capacity(); i++) {
      byte b = sliceBuffer.get(i);
      b *= 2;
      sliceBuffer.put(i, b);
    }

    buffer.clear();

    while (buffer.hasRemaining()) {
      System.out.println(buffer.get());
    }
  }

}
