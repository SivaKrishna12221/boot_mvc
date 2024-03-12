package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@SpringBootApplication
public class BootMvcProj20TilesFrameworkApplication {

	@Bean
	public TilesConfigurer createTC() {
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions("/WEB-INF/tiles.xml");
		return tiles;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj20TilesFrameworkApplication.class, args);
	}

}
