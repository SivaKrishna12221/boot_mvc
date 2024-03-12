package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.service.IresolverService;

@Controller
public class ViewResolverController {

	@Autowired
	private IresolverService service;

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}

	@GetMapping("/wish")
	public String displayWishMessage(Map<String, Object> map) {

		String msg = service.getWishMessage();
		map.put("message", msg);
		return "display";
	}
}
