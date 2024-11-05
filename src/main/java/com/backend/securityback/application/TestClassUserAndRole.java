package com.backend.securityback.application;

import javax.persistence.EntityManager;

import com.ipd.library_sec.config.dao.AppRoleDao;
import com.ipd.library_sec.config.dao.AppUserDao;
import com.ipd.library_sec.config.dto.AppRoleDto;
import com.ipd.library_sec.config.dto.AppUserDto;
import com.ipd.library_sec.config.service.AppRoleService;
import com.ipd.library_sec.config.service.AppUserService;
import com.ipd.library_sec.config.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class TestClassUserAndRole {

    public static void main(String[] args) {
        // Initialize the EntityManager using HibernateUtil
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();

        // Initialize the DAO and Service with the valid EntityManager
        AppRoleDao roleDao = new AppRoleDao(entityManager);
        AppRoleService roleService = new AppRoleService(roleDao);

        // Create a test role and save it using the service
        AppRoleDto newRoleDto = new AppRoleDto();
        newRoleDto.setNom("ROLE_ADMIN2");
        roleService.createRole(newRoleDto);

        // Retrieve the role from the database
        AppRoleDto savedRole = roleService.getRoleByName("ROLE_ADMIN2");
        if (savedRole != null) {
            System.out.println("Role retrieved successfully: " + savedRole.getNom());
        } else {
            System.out.println("Failed to retrieve role.");
        }

        // Initialize the AppUser DAO and Service
        AppUserDao appUserDao = new AppUserDao(entityManager);
        AppUserService appUserService = new AppUserService(appUserDao, roleDao);

        // Create a test user and assign the retrieved role
        AppUserDto newUserDto = new AppUserDto();
        newUserDto.setEmail("mess2@gmail.com");
        newUserDto.setUserName("Mess2");
        newUserDto.setPassword("123");

        // Add the retrieved role to the user
        List<AppRoleDto> userRoles = new ArrayList<>();
        userRoles.add(savedRole); // Add the retrieved role to the user's roles
        newUserDto.setRoles(userRoles);

        // Save the user with the assigned roles
        appUserService.updateUser(newUserDto);

        System.out.println("User saved with roles successfully!");

        // Clean up resources
        entityManager.close();
        HibernateUtil.shutdown();
    }
}
