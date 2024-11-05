package com.backend.securityback.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.backend.securityback.dao.AppRoleDao;
import com.backend.securityback.dao.AppUserDao;
import com.backend.securityback.dto.AppRoleDto;
import com.backend.securityback.dto.AppUserDto;
import com.backend.securityback.service.AppRoleService;
import com.backend.securityback.service.AppUserService;
import com.backend.securityback.service.IAppUserService;
import com.backend.securityback.util.HibernateUtil;



@WebServlet(name = "assignRole", value = "/assignRole")
public class AssignRoleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IAppUserService userService;
    private AppRoleService roleService; 
    private static final Logger log = LoggerFactory.getLogger(AssignRoleServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            AppUserDao appUserDao = new AppUserDao(entityManager);
            AppRoleDao appRoleDao = new AppRoleDao(entityManager);
            
            userService = new AppUserService(appUserDao, appRoleDao);
            roleService = new AppRoleService(appRoleDao);
            
            System.out.println("AssignRoleServlet initialized successfully");
        } catch (Exception e) {
            throw new ServletException("Failed to initialize AssignRoleServlet", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Fetch users and roles for the form
        List<AppUserDto> userList = userService.listUsers(); // Method to get all users
        List<AppRoleDto> roleList = roleService.listRoles(); // Method to get all roles
        
        req.setAttribute("userList", userList);
        req.setAttribute("roleList", roleList);
        
        req.getRequestDispatcher("/WEB-INF/views/layout-role-assign.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = Long.valueOf(req.getParameter("userId")); // Get user ID from request
        Long roleId = Long.valueOf(req.getParameter("roleId")); // Get role ID from request
        
        log.info("Assigning role ID {} to user with ID {}", roleId, userId);
        
        try {
            userService.assignRoleToUser(userId, roleId); // Call the assignRole method
            resp.sendRedirect(req.getContextPath() + "/user?action=list"); // Redirect to user list page
        } catch (IllegalArgumentException e) {
            log.error("Error assigning role: {}", e.getMessage());
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/account/error.jsp").forward(req, resp); // Forward to error page
        }
    }
}