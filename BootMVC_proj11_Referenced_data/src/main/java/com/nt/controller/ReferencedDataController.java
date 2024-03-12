package com.nt.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.CustomerInfo;
import com.nt.service.ICustomerInfoMgmtService;

@Controller
public class ReferencedDataController {
	@Autowired
	private ICustomerInfoMgmtService service;

	@GetMapping("/shop")
	public String customerHome() {
		return "shop";
	}

	@GetMapping("/cust_form")
	public String getCustomerForm(@ModelAttribute("customer") CustomerInfo custInfo) {
		return "customer_form";
	}

	@PostMapping("/cust_form")
	public String saveCustomerForm(@ModelAttribute("customer") CustomerInfo custInfo) {
		System.out.println(custInfo.toString());
		return "redirect:cust_form";
	}

	@ModelAttribute("countries")
	public Set<String> getPopulateCountries() {
		Set<String> countriesNames = service.populateCountries();
		// countriesNames.forEach(System.out::println);
		return countriesNames;
	}

	@ModelAttribute("languages")
	public Set<String> getPopulateLanguages() {
		Set<String> languages = service.populateLanguages();
		int size = languages.size();
		System.out.println("total languages:" + size);
		languages.forEach(System.out::println);
		return languages;
	}

	@ModelAttribute("hobbiesInfo")
	public Set<String> showHobbies() {
		Set<String> hobbies = service.getHobbies();
		hobbies.forEach(System.out::println);
		return hobbies;
	}
}
