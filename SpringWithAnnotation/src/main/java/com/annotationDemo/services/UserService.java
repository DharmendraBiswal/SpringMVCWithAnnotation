package com.annotationDemo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annotationDemo.dao.UserDao;
import com.annotationDemo.model.User;


@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public Integer register(User user){
		return userDao.addUser(user);
	}
	
	public User validateUser(String userName,String password){
		return userDao.validateUser(userName,password);
	}


}
