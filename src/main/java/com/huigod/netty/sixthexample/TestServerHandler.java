package com.huigod.netty.sixthexample;

import com.huigod.netty.sixthexample.MyDataInfo.MyMessage;
import com.huigod.netty.sixthexample.MyDataInfo.MyMessage.DataType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, MyMessage msg) throws Exception {
    MyDataInfo.MyMessage.DataType dataType = msg.getDataType();

    if (dataType == DataType.PersonType) {
      MyDataInfo.Person person = msg.getPerson();

      System.out.println(person.getName());
      System.out.println(person.getAge());
      System.out.println(person.getAddress());
    } else if (dataType == DataType.DogType) {
      MyDataInfo.Dog dog = msg.getDog();

      System.out.println(dog.getName());
      System.out.println(dog.getAge());
    }else{
      MyDataInfo.Cat cat = msg.getCat();

      System.out.println(cat.getName());
      System.out.println(cat.getCity());
    }
  }
}
