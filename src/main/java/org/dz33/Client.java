package org.dz33;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
    static final String HOST = "127.0.0.1";
    static final int PORT = 8001;

    public static void main(String[] args) throws Exception {

        EventLoopGroup group = new NioEventLoopGroup();
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class) // Використання NIO для нового з'єднання
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new StringDecoder());
                            p.addLast(new StringEncoder());
                            p.addLast(new ClientHandler());
                        }
                    });

            ChannelFuture f = b.connect(HOST, PORT).sync();
            Channel channel = f.channel();

            while (true) {
                String input = userInput.readLine();
                channel.writeAndFlush(input);
                channel.flush();

                if(input.equals("exit")){
                    f.channel().closeFuture().sync();
                    break;
                }
            }
        } finally {
            group.shutdownGracefully();
        }
    }
}
