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

import com.annotationDemo.controllers.LoginController;
import com.annotationDemo.model.Login;
import com.annotationDemo.model.User;
import com.annotationDemo.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
	
	@InjectMocks
	private LoginController loginController;
	
	@Mock
	private UserService userService;
	
	
	@Test
	public void shouldshowLoginPage(){
		
		ModelAndView modelAndView = loginController.showLogin();
		Assert.assertNotNull(modelAndView);
		Assert.assertEquals("Login", modelAndView.getViewName());
	}
	
	@Test
	public void shouldVerifyLoginCredentials(){
		
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
		
		Login login =new Login();
		login.setUserName("abc");
		login.setPassword("123");
		ModelAndView modelAndView =  new ModelAndView();
		modelAndView.setViewName("welcome");
		modelAndView.addObject("firstName", user.getFirstName());
		
		
		
		Mockito.when(userService.validateUser("abc", "123")).thenReturn(user);
		
		Assert.assertNotNull(loginController.loginProcess(request, response, login));
		
		Assert.assertEquals("welcome", modelAndView.getViewName());
		
		Mockito.verify(userService).validateUser("abc", "123");
		
		
	}

	
	@Test
	public void shouldShowErrorMessageForWrongCredentials(){
		
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		
		Login login =new Login();
		login.setUserName("abcd");
		login.setPassword("123");
		
		User user = null;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("message","Username or Password is wrong!!");
		
		Mockito.when(userService.validateUser("abcd", "123")).thenReturn(user);
		
		Assert.assertNotNull(loginController.loginProcess(request, response, login));
		
		Mockito.verify(userService).validateUser("abcd", "123");
		
	}

}
