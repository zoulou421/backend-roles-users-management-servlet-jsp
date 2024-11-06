/*package com.backend.securityback.filters;

import java.io.IOException;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.backend.securityback.dao.AppRoleDao;
import com.backend.securityback.dao.AppUserDao;
import com.backend.securityback.dto.AppRoleDto;
import com.backend.securityback.service.AppRoleService;
import com.backend.securityback.service.AppUserService;
import com.backend.securityback.service.IAppRoleService;
import com.backend.securityback.service.IAppUserService;
import com.backend.securityback.util.HibernateUtil;

@WebFilter({"/admin/*", "/user/*", "/role/*"})
public class AuthFilter implements Filter {
	
    
    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);
    private IAppUserService userService;
    private AppRoleService roleService; 

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            AppUserDao appUserDao = new AppUserDao(entityManager);
            AppRoleDao appRoleDao = new AppRoleDao(entityManager);
            
            userService = new AppUserService(appUserDao, appRoleDao); // Initialize userService
            roleService=new AppRoleService(appRoleDao);
            
            System.out.println("UserService initialized successfully");
        } catch (Exception e) {
            throw new ServletException("Failed to initialize UserServlet", e);
        }
    }
	
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false); // Avoid creating a new session

        // Retrieve the username from the session
        String username = (session != null) ? (String) session.getAttribute("username") : null;

        // Get the requested path
        String path = req.getServletPath();

        // Allow access to login, logout, and register paths without authentication
        if (path.startsWith("/public/") || path.startsWith("/static/") || path.startsWith("/assets/") ||
            path.startsWith("/css/") || path.startsWith("/js/") || path.startsWith("/webjars/") ||
            path.equals("/login") || path.equals("/logout") || path.equals("/register")) {
            chain.doFilter(request, response); // Allow the request
        } else if (username != null) {
            // Fetch user roles from the database using userService
            Set<AppRoleDto> userRoles = userService.getUserRolesByUsername(username); // Implement this method in your service

            boolean hasAccess = false;

            // Check user roles for access control
            if (userRoles.contains("ROLE_ADMIN") && path.startsWith("/admin/")) {
                hasAccess = true; // Allow admin access
            } else if (userRoles.contains("ROLE_USER") && path.startsWith("/user/")) {
                hasAccess = true; // Allow user access
            } else if (userRoles.contains("ROLE_USER") && path.startsWith("/role/")) {
                hasAccess = true; // Allow access to role-related resources if needed
            }

            if (hasAccess) {
                chain.doFilter(request, response); // Allow the request if access is granted
            } else {
                // Redirect to access denied page if the role does not match
                resp.sendRedirect(req.getContextPath() + "/accessDenied");
            }
        } else {
            // Redirect to login page if not authenticated
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

}*/
