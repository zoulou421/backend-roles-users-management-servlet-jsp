package com.backend.securityback.service;

import java.util.List;
import java.util.Set;

import com.backend.securityback.dto.AppRoleDto;
import com.backend.securityback.dto.AppUserDto;


public interface IAppUserService {
	// Registers a new user and returns the registered user as a DTO
    AppUserDto register(AppUserDto userDto);

    // Authenticates the user using email and password
    AppUserDto login(String email, String password);

    // Retrieves a user by their ID
    AppUserDto getUserById(long id);

    // Returns a list of all users
    List<AppUserDto> listUsers();

    // Updates an existing user's details, returns true if successful
   // boolean updateUser(AppUserDto userDto);
    public AppUserDto updateUser(AppUserDto userDto);

    // Deletes a user by their ID, returns true if successful
    boolean deleteUser(long id);

 // ssignRoleToUser
    public void assignRoleToUser(long userId, long roleId);  
    
    Set<AppRoleDto> getUserRolesByUsername(String username);
}
