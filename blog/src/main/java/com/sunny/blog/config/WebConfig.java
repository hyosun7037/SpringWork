package com.sunny.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sunny.blog.config.aop.RoleIntercepter;
import com.sunny.blog.config.aop.SessionIntercepter;

// 필터링
@Configuration // IOC 
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionIntercepter()) // 다른 곳에서 쓸 일 없으면 바로 new로 넣어줌
		.addPathPatterns("/user/**")
		.addPathPatterns("/post/**")
		.addPathPatterns("/post**");
		
		registry.addInterceptor(new RoleIntercepter())
		.addPathPatterns("/admin/**");
	}
}
