package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.entities.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public boolean getAuthenticate(String username, String password) {
		
		System.out.println("in getAuthenticate UserService (2)");
		if (username == null || password == null) {
			System.out.println("checking conditon if userName or password is null");
	        throw new IllegalArgumentException("Username or password cannot be null");
	    }
		System.out.println("checked conditon if userName or password is null");
		
		User user=userDao.findByUsername(username);
		if(user!=null) {
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			System.out.println(user.getId());
		}
		
		System.out.println("After comming back from jpa");
		System.out.println("in getAuthenticate UserService after getting data from database (3)");
		
		if(user!=null)
		{
			return user.getPassword().equals(password);
		}
		return false;
	}

}
