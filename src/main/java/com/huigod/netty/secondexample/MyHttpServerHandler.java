package com.huigod.netty.secondexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.UUID;

public class MyHttpServerHandler extends SimpleChannelInboundHandler<String> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    System.out.println(ctx.channel().remoteAddress());
    ctx.channel().writeAndFlush("from server:" + UUID.randomUUID());
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
