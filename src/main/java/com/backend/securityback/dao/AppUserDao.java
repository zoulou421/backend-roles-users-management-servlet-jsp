package com.backend.securityback.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.backend.securityback.entities.AppRole;
import com.backend.securityback.entities.AppUser;
import com.backend.securityback.util.HibernateUtil;



public class AppUserDao extends RepositoryImpl<AppUser> implements IAppUser {

	private final EntityManager entityManager;

    // Constructor accepting EntityManager
    public AppUserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public AppUser getById(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        AppUser user = null;
        try {
            user = session.get(AppUser.class, id);
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public AppUser get(long id, AppUser appUser) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        AppUser user = session.get(AppUser.class, id);
        session.close();
        return user;
    }

    @Override
    public boolean delete(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean deleted = false;
        try {
            transaction = session.beginTransaction();
            AppUser user = session.get(AppUser.class, id);
            if (user != null) {
                session.delete(user);
                deleted = true;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return deleted;
    }

    @Override
    public List<AppUser> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<AppUser> result = null;
        try {
            Query<AppUser> query = session.createQuery("FROM AppUser", AppUser.class);
            result = query.getResultList();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public AppUser findByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        AppUser user = null;
        try {
            Query<AppUser> query = session.createQuery("FROM AppUser WHERE email = :email", AppUser.class);
            query.setParameter("email", email);
            user = query.uniqueResult(); // Will return null if no user found
        } finally {
            session.close();
        }
        return user;
    }

		@Override
	    public boolean assignRoleToUser(long userId, long roleId) {
	        EntityTransaction transaction = entityManager.getTransaction();
	        boolean assigned = false;
	        try {
	            transaction.begin();
	            AppUser user = entityManager.find(AppUser.class, userId);
	            AppRole role = entityManager.find(AppRole.class, roleId); // Fetch the role by roleId
	            
	            if (user != null && role != null) {
	                user.getRoles().add(role); // Assuming AppUser has a Set<AppRole> roles
	                entityManager.merge(user); // Update user with new role
	                assigned = true;
	            }
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction.isActive()) transaction.rollback();
	            e.printStackTrace();
	        }
	        return assigned;
	    }
    

}
