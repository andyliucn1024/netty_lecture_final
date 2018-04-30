package com.huigod.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *请求和响应必须是message类型
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: Student.proto")
public final class StudentServiceGrpc {

  private StudentServiceGrpc() {}

  public static final String SERVICE_NAME = "com.huigod.proto.StudentService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetRealNameByUsernameMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.huigod.proto.MyRequest,
      com.huigod.proto.MyResponse> METHOD_GET_REAL_NAME_BY_USERNAME = getGetRealNameByUsernameMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.huigod.proto.MyRequest,
      com.huigod.proto.MyResponse> getGetRealNameByUsernameMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.huigod.proto.MyRequest,
      com.huigod.proto.MyResponse> getGetRealNameByUsernameMethod() {
    return getGetRealNameByUsernameMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.huigod.proto.MyRequest,
      com.huigod.proto.MyResponse> getGetRealNameByUsernameMethodHelper() {
    io.grpc.MethodDescriptor<com.huigod.proto.MyRequest, com.huigod.proto.MyResponse> getGetRealNameByUsernameMethod;
    if ((getGetRealNameByUsernameMethod = StudentServiceGrpc.getGetRealNameByUsernameMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealNameByUsernameMethod = StudentServiceGrpc.getGetRealNameByUsernameMethod) == null) {
          StudentServiceGrpc.getGetRealNameByUsernameMethod = getGetRealNameByUsernameMethod = 
              io.grpc.MethodDescriptor.<com.huigod.proto.MyRequest, com.huigod.proto.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.huigod.proto.StudentService", "GetRealNameByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.huigod.proto.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.huigod.proto.MyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetRealNameByUsername"))
                  .build();
          }
        }
     }
     return getGetRealNameByUsernameMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetStudentsByAgeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.huigod.proto.StudentRequest,
      com.huigod.proto.StudentResponse> METHOD_GET_STUDENTS_BY_AGE = getGetStudentsByAgeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.huigod.proto.StudentRequest,
      com.huigod.proto.StudentResponse> getGetStudentsByAgeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.huigod.proto.StudentRequest,
      com.huigod.proto.StudentResponse> getGetStudentsByAgeMethod() {
    return getGetStudentsByAgeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.huigod.proto.StudentRequest,
      com.huigod.proto.StudentResponse> getGetStudentsByAgeMethodHelper() {
    io.grpc.MethodDescriptor<com.huigod.proto.StudentRequest, com.huigod.proto.StudentResponse> getGetStudentsByAgeMethod;
    if ((getGetStudentsByAgeMethod = StudentServiceGrpc.getGetStudentsByAgeMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentsByAgeMethod = StudentServiceGrpc.getGetStudentsByAgeMethod) == null) {
          StudentServiceGrpc.getGetStudentsByAgeMethod = getGetStudentsByAgeMethod = 
              io.grpc.MethodDescriptor.<com.huigod.proto.StudentRequest, com.huigod.proto.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.huigod.proto.StudentService", "GetStudentsByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.huigod.proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.huigod.proto.StudentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetStudentsByAge"))
                  .build();
          }
        }
     }
     return getGetStudentsByAgeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetStudentWrapperByAgesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.huigod.proto.StudentRequest,
      com.huigod.proto.StudentResponseList> METHOD_GET_STUDENT_WRAPPER_BY_AGES = getGetStudentWrapperByAgesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.huigod.proto.StudentRequest,
      com.huigod.proto.StudentResponseList> getGetStudentWrapperByAgesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.huigod.proto.StudentRequest,
      com.huigod.proto.StudentResponseList> getGetStudentWrapperByAgesMethod() {
    return getGetStudentWrapperByAgesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.huigod.proto.StudentRequest,
      com.huigod.proto.StudentResponseList> getGetStudentWrapperByAgesMethodHelper() {
    io.grpc.MethodDescriptor<com.huigod.proto.StudentRequest, com.huigod.proto.StudentResponseList> getGetStudentWrapperByAgesMethod;
    if ((getGetStudentWrapperByAgesMethod = StudentServiceGrpc.getGetStudentWrapperByAgesMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentWrapperByAgesMethod = StudentServiceGrpc.getGetStudentWrapperByAgesMethod) == null) {
          StudentServiceGrpc.getGetStudentWrapperByAgesMethod = getGetStudentWrapperByAgesMethod = 
              io.grpc.MethodDescriptor.<com.huigod.proto.StudentRequest, com.huigod.proto.StudentResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.huigod.proto.StudentService", "GetStudentWrapperByAges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.huigod.proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.huigod.proto.StudentResponseList.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetStudentWrapperByAges"))
                  .build();
          }
        }
     }
     return getGetStudentWrapperByAgesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBiTalkMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.huigod.proto.StreamRequest,
      com.huigod.proto.StreamResponse> METHOD_BI_TALK = getBiTalkMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.huigod.proto.StreamRequest,
      com.huigod.proto.StreamResponse> getBiTalkMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.huigod.proto.StreamRequest,
      com.huigod.proto.StreamResponse> getBiTalkMethod() {
    return getBiTalkMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.huigod.proto.StreamRequest,
      com.huigod.proto.StreamResponse> getBiTalkMethodHelper() {
    io.grpc.MethodDescriptor<com.huigod.proto.StreamRequest, com.huigod.proto.StreamResponse> getBiTalkMethod;
    if ((getBiTalkMethod = StudentServiceGrpc.getBiTalkMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getBiTalkMethod = StudentServiceGrpc.getBiTalkMethod) == null) {
          StudentServiceGrpc.getBiTalkMethod = getBiTalkMethod = 
              io.grpc.MethodDescriptor.<com.huigod.proto.StreamRequest, com.huigod.proto.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.huigod.proto.StudentService", "BiTalk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.huigod.proto.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.huigod.proto.StreamResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("BiTalk"))
                  .build();
          }
        }
     }
     return getBiTalkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentServiceStub newStub(io.grpc.Channel channel) {
    return new StudentServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StudentServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StudentServiceFutureStub(channel);
  }

  /**
   * <pre>
   *请求和响应必须是message类型
   * </pre>
   */
  public static abstract class StudentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRealNameByUsername(com.huigod.proto.MyRequest request,
        io.grpc.stub.StreamObserver<com.huigod.proto.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUsernameMethodHelper(), responseObserver);
    }

    /**
     */
    public void getStudentsByAge(com.huigod.proto.StudentRequest request,
        io.grpc.stub.StreamObserver<com.huigod.proto.StudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStudentsByAgeMethodHelper(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.huigod.proto.StudentRequest> getStudentWrapperByAges(
        io.grpc.stub.StreamObserver<com.huigod.proto.StudentResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentWrapperByAgesMethodHelper(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.huigod.proto.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<com.huigod.proto.StreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBiTalkMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealNameByUsernameMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.huigod.proto.MyRequest,
                com.huigod.proto.MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME)))
          .addMethod(
            getGetStudentsByAgeMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.huigod.proto.StudentRequest,
                com.huigod.proto.StudentResponse>(
                  this, METHODID_GET_STUDENTS_BY_AGE)))
          .addMethod(
            getGetStudentWrapperByAgesMethodHelper(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.huigod.proto.StudentRequest,
                com.huigod.proto.StudentResponseList>(
                  this, METHODID_GET_STUDENT_WRAPPER_BY_AGES)))
          .addMethod(
            getBiTalkMethodHelper(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.huigod.proto.StreamRequest,
                com.huigod.proto.StreamResponse>(
                  this, METHODID_BI_TALK)))
          .build();
    }
  }

  /**
   * <pre>
   *请求和响应必须是message类型
   * </pre>
   */
  public static final class StudentServiceStub extends io.grpc.stub.AbstractStub<StudentServiceStub> {
    private StudentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRealNameByUsername(com.huigod.proto.MyRequest request,
        io.grpc.stub.StreamObserver<com.huigod.proto.MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStudentsByAge(com.huigod.proto.StudentRequest request,
        io.grpc.stub.StreamObserver<com.huigod.proto.StudentResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStudentsByAgeMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.huigod.proto.StudentRequest> getStudentWrapperByAges(
        io.grpc.stub.StreamObserver<com.huigod.proto.StudentResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetStudentWrapperByAgesMethodHelper(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.huigod.proto.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<com.huigod.proto.StreamResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBiTalkMethodHelper(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *请求和响应必须是message类型
   * </pre>
   */
  public static final class StudentServiceBlockingStub extends io.grpc.stub.AbstractStub<StudentServiceBlockingStub> {
    private StudentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.huigod.proto.MyResponse getRealNameByUsername(com.huigod.proto.MyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealNameByUsernameMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.huigod.proto.StudentResponse> getStudentsByAge(
        com.huigod.proto.StudentRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStudentsByAgeMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *请求和响应必须是message类型
   * </pre>
   */
  public static final class StudentServiceFutureStub extends io.grpc.stub.AbstractStub<StudentServiceFutureStub> {
    private StudentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.huigod.proto.MyResponse> getRealNameByUsername(
        com.huigod.proto.MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME_BY_USERNAME = 0;
  private static final int METHODID_GET_STUDENTS_BY_AGE = 1;
  private static final int METHODID_GET_STUDENT_WRAPPER_BY_AGES = 2;
  private static final int METHODID_BI_TALK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USERNAME:
          serviceImpl.getRealNameByUsername((com.huigod.proto.MyRequest) request,
              (io.grpc.stub.StreamObserver<com.huigod.proto.MyResponse>) responseObserver);
          break;
        case METHODID_GET_STUDENTS_BY_AGE:
          serviceImpl.getStudentsByAge((com.huigod.proto.StudentRequest) request,
              (io.grpc.stub.StreamObserver<com.huigod.proto.StudentResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STUDENT_WRAPPER_BY_AGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentWrapperByAges(
              (io.grpc.stub.StreamObserver<com.huigod.proto.StudentResponseList>) responseObserver);
        case METHODID_BI_TALK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biTalk(
              (io.grpc.stub.StreamObserver<com.huigod.proto.StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.huigod.proto.StudentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentService");
    }
  }

  private static final class StudentServiceFileDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier {
    StudentServiceFileDescriptorSupplier() {}
  }

  private static final class StudentServiceMethodDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StudentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentServiceFileDescriptorSupplier())
              .addMethod(getGetRealNameByUsernameMethodHelper())
              .addMethod(getGetStudentsByAgeMethodHelper())
              .addMethod(getGetStudentWrapperByAgesMethodHelper())
              .addMethod(getBiTalkMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
