package com.nt.configur;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nt.interceptor.TimeOutCheckInterceptor;

@Component
public class CustomConfiguration implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("CustomConfiguration.addInterceptors()");

		registry.addInterceptor(new TimeOutCheckInterceptor());

	}

}
