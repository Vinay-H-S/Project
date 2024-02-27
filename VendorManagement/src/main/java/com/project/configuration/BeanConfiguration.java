package com.project.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.project")
@EnableWebMvc
public class BeanConfiguration {

	public BeanConfiguration() {
		System.out.println("Create the beanconfiguration");
	}
	
	@Bean
	public ViewResolver viewResolver(){
		System.out.println("ViewReslover");
		ViewResolver resolver=new InternalResourceViewResolver("/",".jsp");
		return resolver;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		System.out.println("EntityManagerFactoryBean");
		return new LocalContainerEntityManagerFactoryBean();
	}
	
}
