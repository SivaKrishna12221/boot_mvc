package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.model.SYRProperties;

@Controller
public class InternationalizationControllerClass {

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}

	@GetMapping("/syr_registration")
	public String showSyrRegistrationPage(@ModelAttribute("investor") SYRProperties syr) {
		System.out.println("InternationalizationControllerClass.showSyrRegistrationPage()");
		return "SYR_properties";
	}
}
