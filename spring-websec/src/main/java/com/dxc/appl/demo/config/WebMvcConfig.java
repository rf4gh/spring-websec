package com.dxc.appl.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("index"); this is handled by the WelcomeController !
		registry.addViewController("/public").setViewName("public");
		registry.addViewController("/pageOne").setViewName("pageOne");
		registry.addViewController("/pageTwo").setViewName("pageTwo");
	}
}
