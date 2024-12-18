package com.backend.securityback.servlet;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.backend.securityback.dao.AppRoleDao;
import com.backend.securityback.dao.AppUserDao;
import com.backend.securityback.dto.AppUserDto;
import com.backend.securityback.service.AppUserService;
import com.backend.securityback.service.IAppUserService;
import com.backend.securityback.util.HibernateUtil;

import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private IAppUserService userService;

    @Override
    public void init() throws ServletException {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String action = request.getParameter("action");
        
        if (action == null) {
            listUsers(request, response);
            return;
        }

        switch (action) {
            case "add":
                showUserForm(request, response, null);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            default:
                listUsers(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        AppUserDto userDto = new AppUserDto();
        userDto.setId(idStr != null && !idStr.isEmpty() ? Long.parseLong(idStr) : 0);
        userDto.setUserName(userName);
        userDto.setEmail(email);
        userDto.setPassword(password);

        if (userDto.getId() > 0) {
            userService.updateUser(userDto);
        } else {
            userService.register(userDto);
        }
        
        response.sendRedirect(request.getContextPath() + "/user?action=list");
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AppUserDto> userList = userService.listUsers();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/WEB-INF/views/layout-user-list.jsp").forward(request, response);
    }

    private void showUserForm(HttpServletRequest request, HttpServletResponse response, AppUserDto userDto) throws ServletException, IOException {
        request.setAttribute("user", userDto);
        request.getRequestDispatcher("/WEB-INF/views/layout-user-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        AppUserDto user = userService.getUserById(id);
        if (user != null) {
            showUserForm(request, response, user);
        } else {
            response.sendRedirect(request.getContextPath() + "/user?action=list");
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        userService.deleteUser(id);
        response.sendRedirect(request.getContextPath() + "/user?action=list");
    }

    
}
