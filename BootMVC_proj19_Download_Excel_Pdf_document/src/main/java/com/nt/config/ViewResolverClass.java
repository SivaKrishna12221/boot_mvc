package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.XmlViewResolver;

import jakarta.servlet.ServletContext;

@Component
public class ViewResolverClass implements WebMvcConfigurer {

	@Autowired
	private ServletContext sc;

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		XmlViewResolver xmlresolver = new XmlViewResolver();
		xmlresolver.setLocation(new FileSystemResource(sc.getRealPath("/") + "WEB-INF/views.xml"));
		registry.viewResolver(xmlresolver);
	}

}
