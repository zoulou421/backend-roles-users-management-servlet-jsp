package com.backend.securityback.websockets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="server", value="/server")
public class ServerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to server-side JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/websockets/server.jsp");
        dispatcher.forward(request, response);
    }
}

