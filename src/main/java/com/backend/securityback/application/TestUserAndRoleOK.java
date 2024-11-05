package com.backend.securityback.application;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;

import com.ipd.library_sec.config.dao.AppRoleDao;
import com.ipd.library_sec.config.dao.AppUserDao;
import com.ipd.library_sec.config.dto.AppRoleDto;
import com.ipd.library_sec.config.dto.AppUserDto;
import com.ipd.library_sec.config.service.AppRoleService;
import com.ipd.library_sec.config.service.AppUserService;
import com.ipd.library_sec.config.util.HibernateUtil;

	public class TestUserAndRoleOK {

	    public static void main(String[] args) {
	        // Initialize the EntityManager using HibernateUtil
	        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();

	        // Initialize the DAO and Service with the valid EntityManager
	        AppRoleDao roleDao = new AppRoleDao(entityManager);
	        AppRoleService roleService = new AppRoleService(roleDao);

	        // Create a test role to demonstrate saving
	        AppRoleDto newRoleDto = new AppRoleDto();
	        newRoleDto.setNom("ROLE_ADMIN");

	        // Use the service to save the role
	        roleService.createRole(newRoleDto);

	        // Output the result
	        System.out.println("Role saved successfully!");
	        
	        
	        AppUserDao appUserDao = new AppUserDao(entityManager);
	        
	        AppUserService appUserService = new AppUserService(appUserDao,roleDao);
	        
	     // Create a test User to demonstrate saving
	        AppUserDto newUserDto = new AppUserDto();
	        newUserDto.setEmail("mess@gmail.com");
	        newUserDto.setUserName("Mess");
	        newUserDto.setPassword("123");

	        // Use the service to save the role
	        appUserService.updateUser(newUserDto);


	        // Clean up resources
	        entityManager.close();
	        HibernateUtil.shutdown();
	    }
	}
