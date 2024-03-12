package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@SpringBootApplication
public class BootMvcProj20TilesFrameworkApplication {

	@Bean("tilesConfiguration")
	public TilesConfigurer createTC() {
		TilesConfigurer tilesConfig = new TilesConfigurer();
		tilesConfig.setDefinitions("/WEB-INF/tiles.xml");
		return tilesConfig;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj20TilesFrameworkApplication.class, args);
	}

}
