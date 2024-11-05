package com.backend.securityback.dao;

import java.util.List;

import com.backend.securityback.entities.AppUser;


public interface IAppUser extends Repository<AppUser> {
	public boolean save(AppUser appUser);

	public AppUser getById(long id);

	public boolean update(AppUser appUser);

	public boolean delete(long id);

	public List<AppUser> list();

	public AppUser findByEmail(String email);
	
	//Repository
	public AppUser get(long id, AppUser appUser);
	
	// New method to assign a role to a user
    public boolean assignRoleToUser(long userId, long roleId);
}
