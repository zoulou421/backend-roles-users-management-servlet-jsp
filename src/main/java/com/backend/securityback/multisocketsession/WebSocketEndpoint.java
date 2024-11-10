package com.backend.securityback.multisocketsession;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocketEndpointSession")
public class WebSocketEndpoint {

    private static final Map<String, Session> clients = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session) throws IOException {
        clients.put(session.getId(), session);
        session.getBasicRemote().sendText("Connected to server with session ID: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("Received from client " + session.getId() + ": " + message);
        
        // Respond only to the specific client session that sent the message
        session.getBasicRemote().sendText("Server response to client " + session.getId() + ": " + message);

        // Example: Broadcast the message to all clients except the sender
        for (Session client : clients.values()) {
            if (!client.getId().equals(session.getId()) && client.isOpen()) {
                client.getBasicRemote().sendText("Broadcast from server: " + message);
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        clients.remove(session.getId());
        System.out.println("Session closed: " + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.err.println("Error on session " + session.getId() + ": " + throwable.getMessage());
    }
}