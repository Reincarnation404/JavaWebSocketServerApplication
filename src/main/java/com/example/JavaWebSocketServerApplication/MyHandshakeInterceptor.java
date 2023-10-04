package com.example.JavaWebSocketServerApplication;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

public class MyHandshakeInterceptor implements HandshakeInterceptor {
//    private static final Logger logger = LoggerFactory.getLogger(com.example.JavaWebSocketServerApplication.MyHandshakeInterceptor.class);
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
          //by ChatGPT  //失敗
//        // 在这里进行 WebSocket 握手前的处理
//        // 检查请求header中的协议升级信息，确保请求的是正确的子协议（"mqtt" 或 "mqttv3.1"）
//        if ("mqtt".equalsIgnoreCase(request.getHeaders().getFirst("Sec-WebSocket-Protocol")) || "mqttv3.1".equalsIgnoreCase(request.getHeaders().getFirst("Sec-WebSocket-Protocol"))) {
//            return true;
//        }
//
//        // 如果子协议不匹配，可以拒绝握手并返回 false
        return false;

        //參考: https://blog.csdn.net/weixin_44330810/article/details/126894586  //失敗
//        HttpServletRequest req = ((ServletServerHttpRequest) request).getServletRequest();
//        HttpServletResponse res = ((ServletServerHttpResponse) response).getServletResponse();
//        if (!req.getHeader("Sec-WebSocket-Protocol").isEmpty()){
//            res.addHeader("Sec-WebSocket-Protocol",req.getHeader("Sec-WebSocket-Protocol"));
//            return true;
//        }
//        return false;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}
