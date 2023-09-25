package com.example.JavaWebSocketServerApplication;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.ArrayList;
import java.util.List;


public class WebSocketHandler extends AbstractWebSocketHandler {

    //建一個List存放session
    private List<WebSocketSession> sessions = new ArrayList<>();

    //To handle the incoming messages that arrive in the server.
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        String msg = message.getPayload();
//        session.sendMessage(new TextMessage(msg));
//        System.out.println("回覆:"+msg);

        //把list裡的session取出來
        for (WebSocketSession clientSession : sessions) {
            //如果不等於傳訊息的那個session
            if (clientSession != session) {
                //傳訊息給其他session
                clientSession.sendMessage(message);
            }
        }
    }

    //如果建立連線 把session加進List裡
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    ////如果斷開連線 把session從List裡移出
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
    }

}
