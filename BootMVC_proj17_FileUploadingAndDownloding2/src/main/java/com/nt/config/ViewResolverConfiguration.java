package com.nt.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Component
public class ViewResolverConfiguration implements WebMvcConfigurer {

	/*
	 * @Override
	 * public void configureViewResolvers(ViewResolverRegistry registry) {
	 * InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	 * resolver.setPrefix("/WEB-INF/pages/");
	 * resolver.setSuffix(".jsp");
	 * registry.viewResolver(resolver);
	 * }
	 */

	/*
	 * @Override
	 * public void configureViewResolvers(ViewResolverRegistry registry) {
	 * UrlBasedViewResolver resolver = new UrlBasedViewResolver();
	 * resolver.setPrefix("/WEB-INF/pages/");
	 * resolver.setSuffix(".jsp");
	 * resolver.setViewClass(JstlView.class);
	 * registry.viewResolver(resolver);
	 * }
	 */

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setBasename("com/nt/commons/views");
		registry.viewResolver(resolver);
	}
}
