package com.huigod.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OldServer {

  public static void main(String[] args) throws Exception {
    ServerSocket serverSocket = new ServerSocket(8899);

    while (true) {
      Socket socket = serverSocket.accept();
      DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

      try {
        byte[] bytes = new byte[4096];

        while (true) {
          int readCount = dataInputStream.read(bytes, 0, bytes.length);
          if (-1 == readCount) {
            break;
          }
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

}
