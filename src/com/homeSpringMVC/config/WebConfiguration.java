package com.homeSpringMVC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
	@EnableWebMvc
	//Import
	@ComponentScan("com.homeSpringMVC.controller")
	public class WebConfiguration implements WebMvcConfigurer
	{
		@Bean
		public UrlBasedViewResolver viewResolver() 
		{
			UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
			viewResolver.setViewClass(JstlView.class);
			viewResolver.setPrefix("/WEB-INF/views/");
			viewResolver.setSuffix(".jsp");
			return viewResolver;
		}
	}

