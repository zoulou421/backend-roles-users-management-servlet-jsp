package com.backend.securityback.servlet;

import javax.persistence.EntityManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.backend.securityback.dao.AppRoleDao;
import com.backend.securityback.dao.AppUserDao;
import com.backend.securityback.dto.AppUserDto;
import com.backend.securityback.service.AppUserService;
import com.backend.securityback.service.IAppUserService;
import com.backend.securityback.util.HibernateUtil;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "login2", value = "/login2")
public class LoginServletOK extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final Logger log = LoggerFactory.getLogger(LoginServletOK.class);

    private IAppUserService userService;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            AppUserDao appUserDao = new AppUserDao(entityManager);
            AppRoleDao appRoleDao = new AppRoleDao(entityManager);
            userService = new AppUserService(appUserDao, appRoleDao); // Initialize userService
            System.out.println("UserService initialized successfully");
        } catch (Exception e) {
            throw new ServletException("Failed to initialize UserServlet", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Forward to login page
        req.getRequestDispatcher("/WEB-INF/account/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        // Log the email for debugging
        log.info("Email sent is {}", email);
        

        try {
            // Instead of passing the hashed password, we should call login with original password
            // AppUserDto user = userService.login(email, hashedPassword); // Do not hash again

            // Call login with the original password
            AppUserDto user = userService.login(email, password);
            req.getSession().setAttribute("email", email);
            resp.sendRedirect("user"); // Redirect to user page upon successful login
        } catch (RuntimeException e) {
            log.error("Login failed: {}", e.getMessage());
            resp.sendRedirect("login?error=true"); // Redirect back to login page with error indication
        }
    }

    
}
