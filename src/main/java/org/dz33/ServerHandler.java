package org.dz33;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerHandler.class);

    // Список підключених клієнтських каналів
    static final List<Channel> channels = new ArrayList<>();

    // Щоразу, коли клієнт підключається до сервера через канал,
    // додаємо його канал до списку каналів.
    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        LOGGER.info("Client ID {} успішно підключився", ctx.channel().id());
        channels.add(ctx.channel());
        ctx.channel().writeAndFlush("Привіт! \n" +
                "Доступні команди: \n" +
                "exit\n" +
                "hi\n");
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) {
        LOGGER.info("Кліент ID {} написав повідомлення: {}", ctx.channel().id(), msg);
        switch (msg) {
            case "exit":
                channels.remove(ctx.channel());
                ctx.channel().writeAndFlush("Бай бай!");
                ctx.close();
                break;
            case "hi":
                ctx.channel().writeAndFlush("Привіт!!");
                break;
            default:
                ctx.channel().writeAndFlush("Такої команди немає!!!");
                break;
        }
        if(msg.equals("exit")) {
            channels.remove(ctx.channel());
            ctx.channel().writeAndFlush("Бай бай!");
            LOGGER.info("Кліент ID {} вийшов та видалений зі списку!!", ctx.channel().id());
        }
//        for (Channel c : channels) {
//            if(c == ctx.channel()) {
//                c.writeAndFlush("Hello ID " + ctx.channel().id() + '\n');
//            }
//        }
    }

    // У випадку винятку - канал закривається
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("Closing connection for client - " + ctx);
        ctx.close();
    }
}
