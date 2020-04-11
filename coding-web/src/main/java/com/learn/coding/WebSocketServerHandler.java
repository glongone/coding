package com.learn.coding;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author glong
 * @date 2020/4/11 15:05
 * @desc:
 */

public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {

    private WebSocketServerHandshaker                 handshaker;

    private static Map<String, ChannelHandlerContext> channelHandlerContextConcurrentHashMap = new ConcurrentHashMap<String, ChannelHandlerContext>();

    private static final Map<String, String>          replyMap                               = new ConcurrentHashMap<String, String>();

    static {
        replyMap.put("博客", "https://glongone.com:8090");
        replyMap.put("公众号", "ytao公众号");
        replyMap.put("在吗", "在");
        replyMap.put("吃饭了吗", "吃了");
        replyMap.put("你好", "你好");
        replyMap.put("谁", "ytao");
        replyMap.put("几点", "现在本地时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    @Override
    public void messageReceived(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {

        channelHandlerContextConcurrentHashMap.put(channelHandlerContext.channel().toString(), channelHandlerContext);

        // http
        if (msg instanceof FullHttpRequest) {
            handleHttpRequest(channelHandlerContext, (FullHttpRequest) msg);
        } else if (msg instanceof WebSocketFrame) { // WebSocket
            handleWebSocketFrame(channelHandlerContext, (WebSocketFrame) msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContextConcurrentHashMap.size() > 1) {
            for (String key : channelHandlerContextConcurrentHashMap.keySet()) {
                ChannelHandlerContext current = channelHandlerContextConcurrentHashMap.get(key);
                if (channelHandlerContext == current)
                    continue;
                current.flush();
            }
        } else {
            // 单条处理
            channelHandlerContext.flush();
        }
    }

    private void handleHttpRequest(ChannelHandlerContext channelHandlerContext,
                                   FullHttpRequest request) throws Exception {
        // 验证解码是否异常
        if (!"websocket".equals(request.headers().get("Upgrade")) || request.decoderResult().isFailure()) {
            // todo send response bad
            System.err.println("解析http信息异常");
            return;
        }

        // 创建握手工厂类
        WebSocketServerHandshakerFactory factory = new WebSocketServerHandshakerFactory(
                                                                                        "ws:/".concat(channelHandlerContext.channel().localAddress().toString()),
                                                                                        null,
                                                                                        false
        );
        handshaker = factory.newHandshaker(request);
        if (handshaker == null)
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(channelHandlerContext.channel());
        else
            // 响应握手消息给客户端
            handshaker.handshake(channelHandlerContext.channel(), request);
    }

    private void handleWebSocketFrame(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame) {
        // 关闭链路
        if (webSocketFrame instanceof CloseWebSocketFrame) {
            handshaker.close(channelHandlerContext.channel(), (CloseWebSocketFrame) webSocketFrame.retain());
            return;
        }
        // Ping消息
        if (webSocketFrame instanceof PingWebSocketFrame) {
            channelHandlerContext.channel().write(
                                                  new PongWebSocketFrame(webSocketFrame.content().retain())
            );
            return;
        }
    }


}
