package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@SpringBootApplication
public class BootMvcProj19BeanNameViewResolverPdfExcelDocumentApplication {

	@Bean("beanNameViewResolver")
	public BeanNameViewResolver createBNVR() {
		BeanNameViewResolver beanResolver = new BeanNameViewResolver();
		beanResolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return beanResolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj19BeanNameViewResolverPdfExcelDocumentApplication.class, args);
	}

}
