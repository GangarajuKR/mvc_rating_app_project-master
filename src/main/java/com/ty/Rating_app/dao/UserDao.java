package com.ty.Rating_app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Rating_app.dto.User;

@Repository
public class UserDao {
	
	@Autowired
	EntityManager manager;
	
	@Autowired
	EntityTransaction transaction;
	
	public User saveUser(User user) {
		transaction.begin();
		manager.persist(user);
		transaction.commit();
		return user;
	}
	public User getUserById(int id) {
		User user = manager.find(User.class, id);
		if(user!=null) {
			return user;
		}
		return null;
	}
	
	public User updateUser(int id,User user) {
		User u = getUserById(id);
		if(u!=null) {
			transaction.begin();
			manager.merge(user);
			transaction.commit();
			return user;
		}
		return null;
	}
	public User validateUser(String name,String password) {
		Query query = manager.createQuery("select u from User u where u.userName=?1 AND u.password=?2");;
		query.setParameter(1, name);
		query.setParameter(2, password);
		List<User> users = query.getResultList();
		if (users.size() > 0) {
			User u = users.get(0);
			return u;
		} else {
			return null;
		}
	}
	
	public User deleteUserById(int id) {
		User user = getUserById(id);
		if(user!=null) {
			manager.remove(user);
			return user;
		}
		return null;
	}
	
	public List<User> listUsers(){
		Query query = manager.createQuery("select u from User u");
		List<User> users = query.getResultList();
		return users;
	}
	
}
