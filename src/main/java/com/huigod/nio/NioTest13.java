package com.huigod.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class NioTest13 {

  public static void main(String[] args) throws Exception{
    String inputFile = "NioTest13_In.txt";
    String outputFile = "NioTest13_Out.txt";

    RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile, "r");
    RandomAccessFile outputRandomAccessFile = new RandomAccessFile(outputFile, "rw");

    long intpuLength = inputRandomAccessFile.length();

    FileChannel inputFileChannel = inputRandomAccessFile.getChannel();
    FileChannel outputFileChannel = outputRandomAccessFile.getChannel();

    MappedByteBuffer inputData = inputFileChannel.map(MapMode.READ_ONLY, 0, intpuLength);

    System.out.println("======================");

    Charset.availableCharsets().forEach((k,v)->{
      System.out.println(k + "," + v);
    });

    System.out.println("======================");

    Charset charset = Charset.forName("utf-8");
    //字节数组转换为字符串
    CharsetDecoder decoder = charset.newDecoder();
    //字符串转换为字节数组
    CharsetEncoder encoder = charset.newEncoder();

    CharBuffer charBuffer = decoder.decode(inputData);

    ByteBuffer outputData = encoder.encode(charBuffer);

    outputFileChannel.write(outputData);

    inputRandomAccessFile.close();
    outputRandomAccessFile.close();
  }

}
