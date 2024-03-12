package com.nt.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ViewResolverConfigurer implements WebMvcConfigurer {

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

	/*
	 * @Override
	 * public void configureViewResolvers(ViewResolverRegistry registry) {
	 * UrlBasedViewResolver resolver = new UrlBasedViewResolver();
	 * resolver.setPrefix("/WEB-INF/pages/");
	 * resolver.setSuffix(".jsp");
	 * // resolver.setViewClass(InternalResourceView.class);// if we use
	 * // InternalResourceView class we need to add jstl tag only when jstl tags are
	 * // added other wise not required
	 * resolver.setViewClass(JstlView.class);// If we use JstlView class
	 * // irrespective of usage jstl tags we need to add
	 * // the jstl jar file.it is mandatory
	 * registry.viewResolver(resolver);
	 * 
	 * }
	 */
	/*
	 * @Override
	 * public void configureViewResolvers(ViewResolverRegistry registry) {
	 * 
	 * ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
	 * resolver.setBasename("com/nt/commons/pages");
	 * registry.viewResolver(resolver);
	 * }
	 *//// It is not working

}
