package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterceptorController {

	@GetMapping("/")
	public String showGovtHospital() {
		return "govt_hospital";
	}
}
