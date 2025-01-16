package org.dz33;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler<String> {
    // Виводить повідомлення, отримане від сервера
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
        System.out.println("SERVER: " + msg);
    }
}
