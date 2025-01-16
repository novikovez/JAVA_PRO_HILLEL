package org.dz33;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.Coffee.CoffeeOrderBoard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server {
    // Порт, на якому сервер буде прослуховувати з'єднання
    static final int PORT = 8001;
    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) throws Exception {

        // Конфігурація серверу

        // Створюємо групи boss та worker.
        // Boss приймає підключення клієнта.
        // Worker обробляє подальшу комунікацію через з'єднання.
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup) // Встановлення boss та worker груп
                    .channel(NioServerSocketChannel.class) // Використання NIO для нового з'єднання
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            ChannelPipeline p = ch.pipeline();
                            // Комунікація сокет-канал відбувається у потоках байтів.
                            // Декодер рядків і кодувальник допомагають перетворенню
                            // між байтами та рядком.
                            p.addLast(new StringDecoder());
                            p.addLast(new StringEncoder());
                            // Обробник на сервері
                            p.addLast(new ServerHandler());
                        }
                    });
            // Стартуємо сервер
            ChannelFuture f = b.bind(PORT).sync();

            LOGGER.info("Server started and waiting for clients...");

            // Очікування доки сокет сервера не буде закрито
            f.channel().closeFuture().sync();
        } finally {
            // Завершення всіх циклів обробки подій,
            // щоб завершити всі потоки.
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
