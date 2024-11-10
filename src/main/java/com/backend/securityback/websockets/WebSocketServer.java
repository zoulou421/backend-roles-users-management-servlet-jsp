package com.backend.securityback.websockets;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
/**
 * @ServerEndpoint: Specifies the WebSocket endpoint URL.
   @OnOpen: Invoked when a new WebSocket connection is opened.
   @OnMessage: Handles incoming messages from clients.
   @OnClose: Invoked when the connection is closed.
   @OnError: Called when an error occurs during communication.
 */

@ServerEndpoint("/websocket/endpoint")
public class WebSocketServer {
	// Store all sessions connected to the endpoint
    private static final Set<Session> sessions = new CopyOnWriteArraySet<>();
    
 // Called when a new WebSocket connection is established
    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        System.out.println("New connection opened: " + session.getId());
    }
    
 // Called when a WebSocket connection is closed
    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        System.out.println("Connection closed: " + session.getId());
    }
    
 // Called when a message is received from a client
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Message received: " + message);
        broadcast("Echo from server: " + message);  // Echo message to all clients
    }  
    
    
 // Called when an error occurs
    @OnError
    public void onError(Session session, Throwable throwable) {
        System.err.println("Error occurred on connection " + session.getId() + ": " + throwable.getMessage());
    }
    
 // Broadcast a message to all clients
    private static void broadcast(String message) {
        for (Session session : sessions) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
