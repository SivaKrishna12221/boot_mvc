package com.nt;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProj16I18InternationalizationApplication {

	@Bean("messsageSource")
	public ResourceBundleMessageSource createrbms() {
		System.out.println(
				"BootMvcProj16I18InternationalizationApplication.createrbms()");
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("com/nt/commons/app");
		return source;
	}

	@Bean("localeResolver")
	public SessionLocaleResolver createslr() {
		System.out.println(
				"BootMvcProj16I18InternationalizationApplication.createslr()");
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en", "US"));
		return resolver;
	}

	@Bean("lci")
	public LocaleChangeInterceptor createLCI() {
		System.out.println(
				"BootMvcProj16I18InternationalizationApplication.createLCI()");
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	public static void main(String[] args) {
		SpringApplication.run(
				BootMvcProj16I18InternationalizationApplication.class, args);
	}

}
