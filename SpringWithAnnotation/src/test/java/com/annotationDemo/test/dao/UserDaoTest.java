package com.annotationDemo.test.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.annotationDemo.dao.UserDao;
import com.annotationDemo.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {
	
	@InjectMocks
	private UserDao userDao;
	
	@Mock
	private EntityManager entityManager;
	
	@Mock
	private Query query;
	
	
	@Test
	public void shouldAddUserToDataBase(){
		
		User user = new User();
		user.setUserId(2);
		
		Mockito.doNothing().when(entityManager).persist(user);
		
		Assert.assertEquals(user.getUserId(), userDao.addUser(user));
		
		
	    Mockito.verify(entityManager).persist(user);
	}
	
	@Test
	public void shouldValidateUser(){
		
		List<User> users = new ArrayList<User>();
		User user = new User();
		users.add(user);
		
		Mockito.when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
		
		Mockito.when(entityManager.createQuery(Mockito.anyString()).getResultList()).thenReturn(users);
		
		userDao.validateUser("abc","1234");
		
		Mockito.verify(entityManager,Mockito.times(2)).createQuery(Mockito.anyString());
	}
	
	
	@Test
	public void shouldReturnNullValidateUser(){
		
		List<User> users = new ArrayList<User>();
		
		Mockito.when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
		
		Mockito.when(entityManager.createQuery(Mockito.anyString()).getResultList()).thenReturn(users);
		
		userDao.validateUser("abc","1234");
		
		Mockito.verify(entityManager,Mockito.times(2)).createQuery(Mockito.anyString());
	}

}
