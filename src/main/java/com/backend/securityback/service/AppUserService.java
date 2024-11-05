package com.backend.securityback.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.backend.securityback.dao.IAppRole;
import com.backend.securityback.dao.IAppUser;
import com.backend.securityback.dto.AppUserDto;
import com.backend.securityback.entities.AppRole;
import com.backend.securityback.entities.AppUser;
import com.backend.securityback.mappers.AppUserMapper;


public class AppUserService implements IAppUserService {

	    private final IAppUser appUserDao;
	    private final IAppRole appRoleDao;
	    private final AppUserMapper appUserMapper;

	    public AppUserService(IAppUser appUserDao, IAppRole appRoleDao) {
	        if (appUserDao == null) {
	            throw new IllegalArgumentException("appUserDao cannot be null");
	        }
	        if (appRoleDao == null) {
	            throw new IllegalArgumentException("appRoleDao cannot be null");
	        }
	        this.appUserDao = appUserDao;
	        this.appRoleDao = appRoleDao;
	        this.appUserMapper = new AppUserMapper();
	    }

    @Override
    public AppUserDto register(AppUserDto userDto) {
        // Check if the user already exists by email
        if (appUserDao.findByEmail(userDto.getEmail()) != null) {
            throw new RuntimeException("User already exists with this email: " + userDto.getEmail());
        }

        // Convert UserDto to AppUser entity
        AppUser userEntity = appUserMapper.toUserEntity(userDto);

        // Hash the password before saving it to the database
        String hashedPassword = hashPassword(userDto.getPassword());
        userEntity.setPassword(hashedPassword);

        // Save the user entity
        appUserDao.save(userEntity);

        // Return the mapped UserDto
        return appUserMapper.toUserDto(userEntity);
    }

    // Method to hash the password using BCrypt
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public AppUserDto login(String email, String password) {
        // Fetch user entity by email
        AppUser userEntity = appUserDao.findByEmail(email);
        
        // Check if user exists
        if (userEntity == null) {
            throw new RuntimeException("User not found with this email: " + email);
        }
        
        // Verify password (use BCrypt to check the hashed password)
        if (!BCrypt.checkpw(password, userEntity.getPassword())) {
            throw new RuntimeException("Invalid password for email: " + email);
        }
        
        // Return the mapped user DTO if login is successful
        return appUserMapper.toUserDto(userEntity);
    }

    @Override
    public AppUserDto getUserById(long id) {
        AppUser userEntity = appUserDao.getById(id);
        return appUserMapper.toUserDto(userEntity);
    }

    @Override
    public List<AppUserDto> listUsers() {
        List<AppUser> userEntities = appUserDao.list();
        return appUserMapper.listUserEntitiesToListUserDtos(userEntities);
    }

    @Override
    public boolean updateUser(AppUserDto userDto) {
        AppUser userEntity = appUserMapper.toUserEntity(userDto);
        return appUserDao.update(userEntity); // Assume update method returns boolean
    }

    @Override
    public boolean deleteUser(long id) {
        return appUserDao.delete(id); // Assume delete method returns boolean
    }

    @Override
    public void assignRoleToUser(long userId, long roleId) {
        // Retrieve the user entity by userId
        AppUser userEntity = appUserDao.getById(userId);
        
        // Check if the user exists
        if (userEntity == null) {
            throw new RuntimeException("User not found with ID: " + userId);
        }
        
        // Retrieve the role entity by roleId
        AppRole roleEntity = appRoleDao.getById(roleId);
        
        // Check if the role exists
        if (roleEntity == null) {
            throw new RuntimeException("Role not found with ID: " + roleId);
        }

        // Check if the user already has this role to avoid duplicates
        if (!userEntity.getRoles().contains(roleEntity)) {
            userEntity.getRoles().add(roleEntity); // Assuming AppUser has a Set<AppRole> roles
        }

        // Update the user in the database
        appUserDao.update(userEntity); // Update the user entity
    }
   
}

