package com.example.JavaWebSocketServerApplication;

import jakarta.websocket.HandshakeResponse;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.websocket.server.ServerEndpointConfig;

import java.util.List;

@ServerEndpoint(value = "/webSocket", subprotocols = "mqtt")
public class WebSocketEndpoint extends ServerEndpointConfig.Configurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        super.modifyHandshake(sec, request, response);
        sec.getUserProperties().put("mqtt", List.of("mqtt"));


    }
}
