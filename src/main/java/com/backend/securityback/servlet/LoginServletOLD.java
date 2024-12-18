package com.backend.securityback.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServletOLD extends HttpServlet {
	
/*	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getRequestDispatcher("/WEB-INF/account/login.jsp").forward(req, resp);
		this.getServletContext().getRequestDispatcher("/WEB-INF/account/login.jsp").forward(req, resp);

	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Replace this with actual user verification (e.g., database check)
        boolean isUser = "user".equals(username) && "userpass".equals(password);
        boolean isAdmin = "admin".equals(username) && "adminpass".equals(password);

        if (isUser) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("userHome.jsp"); // Redirect to user home page
        } else if (isAdmin) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", username);
            response.sendRedirect("adminHome.jsp"); // Redirect to admin home page
        } else {
            response.sendRedirect("login.jsp?error=Invalid credentials");
        }
    }
	private static final long serialVersionUID = 1L;
		private IUserService userService=new UserService();
		
		private static final Logger log = LoggerFactory.getLogger(LoginServletOLD.class);
	
	    @Override
	    public void init(ServletConfig config) throws ServletException {
	        
	    }
	
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        // Forward to login page
	        req.getRequestDispatcher("index.jsp").forward(req, resp);///WEB-INF/views/login.jsp
	    }
	
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String email = req.getParameter("email");
	        String password = req.getParameter("password");
	        
	        // Log the email for debugging
	        log.info("Email sent is {}", email);
	
	       
	        Optional<UserDto>user=userService.login(email, password);
	        if(user.isPresent()) {
	        	req.getSession().setAttribute("username", email);
	        	resp.sendRedirect("welcome");
	        }else {
	        	
	        	resp.sendRedirect("login");
	        }
	        
	    }*/
}
