package com.annotationDemo.test.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.annotationDemo.controllers.WelcomeController;

@RunWith(MockitoJUnitRunner.class)
public class WelcomeControllerTest {
	

	@InjectMocks
	private WelcomeController welcomeController;
	
	@Test
	public void shouldDisplayHelloSpring(){
		
		ModelAndView modelAndView = welcomeController.display2();
		
		Assert.assertNotNull(modelAndView);
		Assert.assertEquals("welcome", modelAndView.getViewName());
		Assert.assertEquals("Hello Spring Annotation",modelAndView.getModel().get("message"));
	}

	
	
}
