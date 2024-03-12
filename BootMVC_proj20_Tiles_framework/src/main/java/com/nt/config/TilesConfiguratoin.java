package com.nt.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Component("config")
public class TilesConfiguratoin implements WebMvcConfigurer {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		TilesViewResolver resolver = new TilesViewResolver();
		registry.viewResolver(resolver);
	}

}
