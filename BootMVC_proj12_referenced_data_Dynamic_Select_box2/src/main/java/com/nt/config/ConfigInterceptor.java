package com.nt.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nt.interceptor.TimeOutCheckInterceptor;

@Component
public class ConfigInterceptor implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		System.out.println("ConfigInterceptor.addInterceptors()");
		registry.addInterceptor(new TimeOutCheckInterceptor());
	}
}
