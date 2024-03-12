package com.nit;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootMvcProj01WishMessageGenerator2Application {

    public static void main(String[] args) {
	SpringApplication.run(BootMvcProj01WishMessageGenerator2Application.class, args);
	System.out.println("application:" + new Date());
    }

}
