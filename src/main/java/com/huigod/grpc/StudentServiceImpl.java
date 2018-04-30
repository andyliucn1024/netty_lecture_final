package com.huigod.grpc;

import com.huigod.proto.MyRequest;
import com.huigod.proto.MyResponse;
import com.huigod.proto.StreamRequest;
import com.huigod.proto.StreamResponse;
import com.huigod.proto.StudentRequest;
import com.huigod.proto.StudentResponse;
import com.huigod.proto.StudentResponseList;
import com.huigod.proto.StudentServiceGrpc.StudentServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.UUID;

public class StudentServiceImpl extends StudentServiceImplBase {

  @Override
  public void getRealNameByUsername(MyRequest request,
      StreamObserver<MyResponse> responseObserver) {
    System.out.println("接受到客户端信息： " + request.getUsername());

    responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
    responseObserver.onCompleted();
  }

  @Override
  public void getStudentsByAge(StudentRequest request,
      StreamObserver<StudentResponse> responseObserver) {
    System.out.println("接受到客户端信息： " + request.getAge());

    responseObserver
        .onNext(StudentResponse.newBuilder().setName("张三").setAge(20).setCity("北京").build());
    responseObserver
        .onNext(StudentResponse.newBuilder().setName("李四").setAge(20).setCity("深圳").build());
    responseObserver
        .onNext(StudentResponse.newBuilder().setName("王五").setAge(40).setCity("上海").build());
    responseObserver
        .onNext(StudentResponse.newBuilder().setName("赵六").setAge(50).setCity("天津").build());
    responseObserver.onCompleted();
  }

  @Override
  public StreamObserver<StudentRequest> getStudentWrapperByAges(
      StreamObserver<StudentResponseList> responseObserver) {
    return new StreamObserver<StudentRequest>() {
      @Override
      public void onNext(StudentRequest value) {
        System.out.println("onNext: " + value.getAge());
      }

      @Override
      public void onError(Throwable t) {
        System.out.println(t.getMessage());
      }

      @Override
      public void onCompleted() {
        StudentResponse studentResponse = StudentResponse.newBuilder().setName("张三").setAge(20)
            .setCity("西安").build();
        StudentResponse studentResponse2 = StudentResponse.newBuilder().setName("李四").setAge(30)
            .setCity("广州").build();

        StudentResponseList studentResponseList = StudentResponseList.newBuilder()
            .addStudentResponse(studentResponse).addStudentResponse(studentResponse2).build();

        responseObserver.onNext(studentResponseList);
        responseObserver.onCompleted();
      }
    };
  }

  @Override
  public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
    return new StreamObserver<StreamRequest>() {
      @Override
      public void onNext(StreamRequest value) {
        System.out.println(value.getRequestInfo());

        responseObserver.onNext(
            StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
      }

      @Override
      public void onError(Throwable t) {
        System.out.println(t.getMessage());
      }

      @Override
      public void onCompleted() {
        responseObserver.onCompleted();
      }
    };
  }
}
