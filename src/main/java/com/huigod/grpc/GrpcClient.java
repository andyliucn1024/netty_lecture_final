package com.huigod.grpc;

import com.huigod.proto.MyRequest;
import com.huigod.proto.MyResponse;
import com.huigod.proto.StreamRequest;
import com.huigod.proto.StreamResponse;
import com.huigod.proto.StudentRequest;
import com.huigod.proto.StudentResponse;
import com.huigod.proto.StudentResponseList;
import com.huigod.proto.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.time.LocalDateTime;
import java.util.Iterator;

public class GrpcClient {

  public static void main(String[] args) {
    ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899)
        .usePlaintext().build();
    StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc
        .newBlockingStub(managedChannel);
    StudentServiceGrpc.StudentServiceStub stub = StudentServiceGrpc.newStub(managedChannel);

    MyResponse myResponse = blockingStub
        .getRealNameByUsername(MyRequest.newBuilder().setUsername("zhangsan").build());

    System.out.println(myResponse.getRealname());

    System.out.println("------------------------");

    Iterator<StudentResponse> iter = blockingStub
        .getStudentsByAge(StudentRequest.newBuilder().setAge(20).build());

    while (iter.hasNext()) {
      StudentResponse studentResponse = iter.next();
      System.out.println(
          studentResponse.getName() + "," + studentResponse.getAge() + "," + studentResponse
              .getCity());
    }

    System.out.println("------------------------");

    StreamObserver<StudentResponseList> studentResponseListStreamObserver = new StreamObserver<StudentResponseList>() {
      @Override
      public void onNext(StudentResponseList value) {
        value.getStudentResponseList().forEach(studentResponse -> {
          System.out.println(studentResponse.getName());
          System.out.println(studentResponse.getAge());
          System.out.println(studentResponse.getCity());
          System.out.println("*******************");
        });
      }

      @Override
      public void onError(Throwable t) {
        System.out.println(t.getMessage());
      }

      @Override
      public void onCompleted() {
        System.out.println("completed!");
      }
    };

    //只要客户端以流式的形式向服务端发送请求，那么一定是异步的
    //请求的回调对象
    StreamObserver<StudentRequest> studentRequestStreamObserver = stub
        .getStudentWrapperByAges(studentResponseListStreamObserver);

    studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(20).build());
    studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(30).build());
    studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(40).build());
    studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(50).build());

    studentRequestStreamObserver.onCompleted();

    System.out.println("------------------------");

    StreamObserver<StreamRequest> requestStreamObserver = stub.biTalk(
        new StreamObserver<StreamResponse>() {
          @Override
          public void onNext(StreamResponse value) {
            System.out.println(value.getResponseInfo());
          }

          @Override
          public void onError(Throwable t) {
            System.out.println(t.getMessage());
          }

          @Override
          public void onCompleted() {
            System.out.println("onCompleted");
          }
        });

    for (int i = 0; i < 10; i++) {
      requestStreamObserver.onNext(
          StreamRequest.newBuilder().setRequestInfo(LocalDateTime.now().toString()).build());

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    requestStreamObserver.onCompleted();
    try {
      Thread.sleep(50000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
