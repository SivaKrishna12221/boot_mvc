package com.nt.config_interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nt.interceptors.TimeOutCheckInterceptor;

@Component
public class CustomConfigure implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("CustomConfigure.addInterceptors()");

		registry.addInterceptor(new TimeOutCheckInterceptor());

	}

}
