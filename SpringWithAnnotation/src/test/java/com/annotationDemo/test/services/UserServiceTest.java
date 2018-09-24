package com.annotationDemo.test.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.annotationDemo.dao.UserDao;
import com.annotationDemo.model.User;
import com.annotationDemo.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	

	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserDao userDao;
	
	@Test
	public void shouldRegister(){
		
		User user = new User();
		
		Mockito.when(userDao.addUser(user)).thenReturn(1);
		
		Assert.assertEquals(1,(long)(userService.register(user)));
		
		Mockito.verify(userDao).addUser(user);
	}
	
	@Test
	public void shouldValidateUser(){
		String userName = "abc";
		String password = "1234";
		
		User user = new User();
		Mockito.when(userDao.validateUser(userName, password)).thenReturn(user);
		
	Assert.assertNotNull(userService.validateUser(userName, password));
		
		
	}


}
