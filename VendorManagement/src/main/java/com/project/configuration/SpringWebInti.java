package com.project.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebInti extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	public SpringWebInti() {
		System.out.println("Creating the SpringWebInti");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Creating the getRootConfigClasses");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Creating the getServletConfigClasses");
		return new Class[] {BeanConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Creating the getServletMappings");
		return new String[] {"/"};
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
