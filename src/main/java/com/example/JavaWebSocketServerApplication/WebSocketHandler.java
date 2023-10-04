package com.example.JavaWebSocketServerApplication;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


public class WebSocketHandler extends AbstractWebSocketHandler {

    //建一個List存放session
    private List<WebSocketSession> sessions = new ArrayList<>();


    //To handle the incoming messages that arrive in the server.
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //讓Server重覆自己傳送的話時使用(websocketPractice)
//        String msg = message.getPayload();
//        session.sendMessage(new TextMessage(msg));
//        System.out.println("回覆:"+msg);


        //實現對話時使用(websocketPractice)
        //把list裡的session取出來
//        for (WebSocketSession clientSession : sessions) {
//            //如果不等於傳訊息的那個session
//            if (clientSession != session) {
//                //傳訊息給其他session
//                clientSession.sendMessage(message);
//            }
//        }
//        System.out.println("session.getAttributes()="+session.getAttributes());  //沒東西
//        System.out.println("session.getHandshakeHeaders()="+session.getHandshakeHeaders());  //[host:"10.0.2.2:8080", upgrade:"websocket", connection:"Upgrade", sec-websocket-key:"2M1UhZlyUYQsyE3zBzsLDA==", sec-websocket-version:"13"]
//        System.out.println("session.getAcceptedProtocol()="+session.getAcceptedProtocol());  //沒東西

    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //如果建立連線 把session加進List裡(websocketPractice)
        sessions.add(session);
    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        //如果關閉連線 把session從List裡移出(websocketPractice)
        sessions.remove(session);
    }

}
