package com.huigod.nio;

import java.nio.ByteBuffer;

public class NioTest5 {

  public static void main(String[] args) {
    ByteBuffer buffer = ByteBuffer.allocate(64);

    buffer.putInt(15);
    buffer.putLong(5000000L);
    buffer.putDouble(14.334324);
    buffer.putChar('你');
    buffer.putShort((short) 2);
    buffer.putChar('我');

    buffer.flip();

    System.out.println(buffer.getInt());
    System.out.println(buffer.getLong());
  }

}
