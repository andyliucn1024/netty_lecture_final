package com.huigod.netty.sixthexample;

import com.huigod.netty.sixthexample.MyDataInfo.MyMessage;
import com.huigod.netty.sixthexample.MyDataInfo.MyMessage.DataType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, MyMessage msg) throws Exception {

  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    int randomInt = new Random().nextInt(3);

    MyDataInfo.MyMessage myMessage;
    if (0 == randomInt) {
      myMessage = MyDataInfo.MyMessage.newBuilder()
          .setDataType(DataType.PersonType)
          .setPerson(MyDataInfo.Person.newBuilder().setName("张三").setAge(20)
              .setAddress("深圳")).build();
    } else if (1 == randomInt) {
      myMessage = MyDataInfo.MyMessage.newBuilder()
          .setDataType(DataType.DogType)
          .setDog(MyDataInfo.Dog.newBuilder().setName("一只狗").setAge(20)).build();
    } else {
      myMessage = MyDataInfo.MyMessage.newBuilder()
          .setDataType(DataType.CatType)
          .setCat(MyDataInfo.Cat.newBuilder().setName("一只猫").setCity("上海")).build();
    }

    ctx.channel().writeAndFlush(myMessage);
  }
}
