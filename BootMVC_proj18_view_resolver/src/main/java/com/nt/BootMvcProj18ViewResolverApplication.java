package com.nt;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.view.XmlViewResolver;

@SpringBootApplication
public class BootMvcProj18ViewResolverApplication {

	/*
	 * @Bean("internalResourceViewResolver")
	 * public InternalResourceViewResolver createIRVR() {
	 * InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	 * resolver.setPrefix("/WEB-INF/pages/");
	 * resolver.setSuffix(".jsp");
	 * return resolver;
	 * }
	 */

	/*
	 * @Bean("rbvr")
	 * public ResourceBundleViewResolver createRBVR() {
	 * ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
	 * resolver.setBasename("com/nt/commons/views");
	 * return resolver;
	 * }
	 */

	@Autowired
	private ServletContext sc;

	@Bean("xmlViewResolver")
	public XmlViewResolver createXVR() {
		XmlViewResolver resolver = new XmlViewResolver();
		resolver.setLocation(new FileSystemResource(sc.getRealPath("/") + "WEB-INF/views.xml"));
		return resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj18ViewResolverApplication.class, args);
	}

}
