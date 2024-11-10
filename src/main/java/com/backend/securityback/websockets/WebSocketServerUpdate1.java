package com.backend.securityback.websockets;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServerEndpoint("/websocket/endpoint1")
public class WebSocketServerUpdate1 {
	private static final Logger log = LoggerFactory.getLogger(WebSocketServerUpdate1.class);

    @OnOpen
    public void onOpen(Session session) {
        log.info("Connected: " + session.getId());
        sendMessage(session, "Welcome to the WebSocket server!"); // Send a welcome message
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("Received message: " + message + " from session: " + session.getId());

        // Send a response back to the client
        sendMessage(session, "Server received: " + message);
    }

    @OnClose
    public void onClose(Session session) {
        log.info("Disconnected: " + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("Error in session " + session.getId(), throwable);
    }

    private void sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message); // Send message to client
        } catch (Exception e) {
            log.error("Error sending message", e);
        }
    }
}
