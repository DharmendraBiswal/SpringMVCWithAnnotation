package com.annotationDemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping("/welcome")
	public ModelAndView display2() {

		return new ModelAndView("welcome", "message", "Hello Spring Annotation");

	}

}
