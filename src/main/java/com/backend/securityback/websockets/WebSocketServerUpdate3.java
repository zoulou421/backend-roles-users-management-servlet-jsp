package com.backend.securityback.websockets;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServerEndpoint("/websocket/endpoint3")
public class WebSocketServerUpdate3 {
	private static final Logger logger = LoggerFactory.getLogger(WebSocketServerUpdate3.class);

    // Called when a client opens a WebSocket connection
    @OnOpen
    public void onOpen(Session session) {
        logger.info("Client connected: " + session.getId());
        sendMessage(session, "Welcome! You've connected to the WebSocket server.");
    }

    // Called when a message is received from the client
    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("Received message from client {}: {}", session.getId(), message);

        // Process the message (you can add your business logic here)
        String responseMessage = "Server received your message: " + message;

        // Send the response back to the client
        sendMessage(session, responseMessage);
    }

    // Called when the WebSocket connection is closed
    @OnClose
    public void onClose(Session session) {
        logger.info("Client disconnected: " + session.getId());
    }

    // Called when there is an error with the WebSocket connection
    @OnError
    public void onError(Session session, Throwable throwable) {
        logger.error("Error in WebSocket session " + session.getId(), throwable);
    }

    // Helper method to send a message to the client
    private void sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            logger.error("Error sending message to client " + session.getId(), e);
        }
    }
}
