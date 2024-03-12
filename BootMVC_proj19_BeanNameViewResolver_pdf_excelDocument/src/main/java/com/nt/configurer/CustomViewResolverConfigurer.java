package com.nt.configurer;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Component
public class CustomViewResolverConfigurer implements WebMvcConfigurer {

	/*
	 * @Override
	 * public void configureViewResolvers(ViewResolverRegistry registry) {
	 * 
	 * InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	 * resolver.setPrefix("/WEB-INF/pages/");
	 * resolver.setSuffix(".jsp");
	 * registry.viewResolver(resolver);
	 * }
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		ResourceBundleViewResolver resourceResolver = new ResourceBundleViewResolver();
		resourceResolver.setBasename("com/nt/commons/views");
		registry.viewResolver(resourceResolver);

	}

}
