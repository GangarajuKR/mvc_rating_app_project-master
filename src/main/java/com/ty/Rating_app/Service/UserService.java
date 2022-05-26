package com.ty.Rating_app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.Rating_app.Exception.NoIdFoundException;
import com.ty.Rating_app.dao.UserDao;
import com.ty.Rating_app.dto.User;

@Service
public class UserService {
	
	@Autowired
	UserDao dao;
	
	public User saveUser(User user) {
		User u = dao.saveUser(user);
		if (u == null) {
			throw new NoIdFoundException();
		}
		return u;
	}
	
	public User updateUser(int id,User user) {
		User u = dao.updateUser(id, user);
		if (u == null) {
			throw new NoIdFoundException();
		}
		return u;
	}
	public User deleteUser(int id) {
		User u = dao.deleteUserById(id);
		if (u == null) {
			throw new NoIdFoundException();
		}
		return u;
	}
	
	public User getUserById(int id) {
		User u = dao.getUserById(id);
		if (u == null) {
			throw new NoIdFoundException();
		}
		return u;
	}
	
	public User validateUser(String name,String password) {
		User u = dao.validateUser(name, password);
		if (u == null) {
			throw new NoIdFoundException();
		}
		return u;
	}
	
	public List<User> listusers(){
		List<User> users = dao.listUsers();
		if(users.isEmpty()) {
			return null;
			}
		return users; 
	}
	
	
	
}
