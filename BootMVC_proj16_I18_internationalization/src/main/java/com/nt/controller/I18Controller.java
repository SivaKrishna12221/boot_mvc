package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.model.SYRProperties;

@Controller
public class I18Controller {

	@GetMapping("/")
	public String displayHomePage() {
		return "home";
	}

	@GetMapping("/syr_registration")
	public String displaySyrHomePage(@ModelAttribute("syr") SYRProperties syr) {
		return "syr_register_form";
	}

}
