package com.backend.securityback.websockets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="client", value="/client")
public class ClientServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to client-side JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/websockets/client.jsp");
        dispatcher.forward(request, response);
    }
}

