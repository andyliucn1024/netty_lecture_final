package com.huigod.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

  private Server server;

  private void start() throws Exception {
    this.server = ServerBuilder.forPort(8899).addService(new StudentServiceImpl()).build().start();

    System.out.println("server started!");

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.out.println("关闭jvm");
      GrpcServer.this.stop();
    }));

    System.out.println("执行到这里");

  }

  private void stop() {
    if (null != this.server) {
      this.server.shutdown();
    }
  }

  //让服务端启动之后阻塞
  private void awaitTermination() throws Exception {
    if (null != this.server) {
      this.server.awaitTermination();
    }
  }

  public static void main(String[] args) throws Exception {
    GrpcServer server = new GrpcServer();
    server.start();
    server.awaitTermination();
  }
}
