// websocket.js
const socket = new WebSocket("ws://localhost:8080/securityback/websocket/endpoint");

socket.onopen = function() {
    console.log("WebSocket connection established");
    socket.send("Hello from client!");
};

socket.onmessage = function(event) {
    console.log("Received message: " + event.data);
};

socket.onclose = function() {
    console.log("WebSocket connection closed");
};

socket.onerror = function(error) {
    console.error("WebSocket error:", error);
};
