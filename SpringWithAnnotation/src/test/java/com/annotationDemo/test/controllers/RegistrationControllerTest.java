package com.annotationDemo.test.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.annotationDemo.controllers.RegistrationController;
import com.annotationDemo.model.User;
import com.annotationDemo.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {
	
	@InjectMocks
	private RegistrationController registrationController;
	
	@Mock
	private UserService userService;
	
	@Test
	public void shouldAddNewUser(){
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		
		User user = new User();
		user.setUserName("abc");
		user.setPassword("123");
		user.setFirstName("abcd");
		user.setLastName("def");
		user.setEmail("gdsad");
		user.setAddress("pune");
		user.setPhone(1234);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Registration");
		
		Mockito.when(userService.register(user)).thenReturn(1);
		
		Assert.assertEquals(modelAndView.getViewName(), registrationController.addUser(request, response, user).getViewName());
		
		Mockito.verify(userService).register(user);
	}
	
	@Test
	public void shouldShowRegistrationForm(){
		
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Registration");
		modelAndView.addObject("user", new User());
		
		Assert.assertEquals(modelAndView.getViewName(), registrationController.showRegistration(request, response).getViewName());
		
	}


}
