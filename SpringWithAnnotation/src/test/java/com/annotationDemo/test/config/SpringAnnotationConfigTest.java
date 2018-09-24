package com.annotationDemo.test.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;

import com.annotationDemo.config.SpringAnnotationConfig;

@RunWith(MockitoJUnitRunner.class)
public class SpringAnnotationConfigTest {
	
	
	@InjectMocks
	private SpringAnnotationConfig springAnnotationConfig;
	
	
	@Test
	public void shouldEnableconfigureDefaultServletHandling(){
		
		DefaultServletHandlerConfigurer configurer = Mockito.mock(DefaultServletHandlerConfigurer.class);
		
		springAnnotationConfig.configureDefaultServletHandling(configurer);
		
		Mockito.verify(configurer).enable();
		

		
	}

}
