package com.huigod.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {

  public static void main(String[] args) {
    IntBuffer buffer = IntBuffer.allocate(5);

    System.out.println("capacity: " + buffer.capacity());

    for (int i = 0; i < buffer.capacity(); i++) {
      int randomNumber = new SecureRandom().nextInt(20);
      buffer.put(randomNumber);
    }

    System.out.println("before flip limit: " + buffer.limit());

    buffer.flip();

    System.out.println("after flip limit: " + buffer.limit());

    System.out.println("enter while loop");

    while (buffer.hasRemaining()) {
      System.out.println("position: " + buffer.position());
      System.out.println("limit: " + buffer.limit());
      System.out.println("capacity: " + buffer.capacity());

      System.out.println(buffer.get());
    }
    System.out.println("after while loop");
    System.out.println("position: " + buffer.position());
  }
}
