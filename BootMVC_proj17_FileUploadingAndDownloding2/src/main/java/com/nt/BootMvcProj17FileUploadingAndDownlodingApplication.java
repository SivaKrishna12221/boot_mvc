package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class BootMvcProj17FileUploadingAndDownlodingApplication {

	@Bean("multipartResolver")
	public CommonsMultipartResolver createCMR() {
		CommonsMultipartResolver mpr = new CommonsMultipartResolver();
		mpr.setMaxUploadSize(-1);// unlimited
		mpr.setMaxUploadSizePerFile(1024 * 1024);
		mpr.setPreserveFilename(true);
		return mpr;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj17FileUploadingAndDownlodingApplication.class, args);
	}

}
