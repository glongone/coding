package com.learn.coding;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author glong
 * @date 2020/4/11 14:13
 * @desc:
 */
public class WebSocketServer {

    public static String HOST = "127.0.0.1";

    public static int    PORT = 8806;

    public static void startUp() throws Exception {
        // 监听端口的线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 处理每一条连接的数据读写的线程组
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        // 启动的引导类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            serverBootstrap.group(bossGroup,
                                  workerGroup).channel(NioSctpServerChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {

                                      @Override
                                      protected void initChannel(SocketChannel socketChannel) throws Exception {
                                          ChannelPipeline pipeline = socketChannel.pipeline();
                                          pipeline.addLast("logger", new LoggingHandler(LogLevel.INFO));
                                          // 将请求和返回编码或解码成http
                                          pipeline.addLast("http-code", new HttpServerCodec());
                                          // 使http的多个部分组成一条完整的http
                                          pipeline.addLast("aggregator", new HttpObjectAggregator(65536));
                                          // 向客户端发送H5文件，主要是来支持websocket通信
                                          pipeline.addLast("http-chunked", new ChunkedWriteHandler());
                                          // 服务端自定义处理器
                                          pipeline.addLast("handle", new WebSocketServerHandler());
                                      }
                                  })
                           // 开启心跳模式
                           .childOption(ChannelOption.SO_KEEPALIVE,
                                        true).handler(new ChannelInitializer<NioServerSocketChannel>() {

                                            protected void initChannel(NioServerSocketChannel nioServerSocketChannel) throws Exception {
                                                System.out.println("websocket服务端启动中...");
                                            }

                                        });
            Channel channel = serverBootstrap.bind(HOST, PORT).sync().channel();
            System.out.println("websocket host:" + channel.localAddress().toString().replace("/",""));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
