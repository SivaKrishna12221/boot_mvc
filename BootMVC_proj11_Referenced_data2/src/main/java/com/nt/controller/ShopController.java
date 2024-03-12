package com.nt.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.CustomerInfo;
import com.nt.service.IVeeradeviShopMgmtService;

@Controller
public class ShopController {
	@Autowired
	private IVeeradeviShopMgmtService service;

	@GetMapping("/shop")
	public String showShop() {
		return "shop";
	}

	@GetMapping("/cust_form")
	public String showCustomerForm(@ModelAttribute("cust") CustomerInfo info, Map<String, Object> map) {
		return "customer_details_form";
	}

	@ModelAttribute("countries")
	public Set<String> showCountries() {
		Set<String> countries = service.getSetOfCountries();
		return countries;
	}

	@PostMapping("/cust_form")
	public String saveCustomerForm(@ModelAttribute("customer") CustomerInfo custInfo) {
		System.out.println(custInfo.toString());
		return "redirect:cust_form";
	}

	@ModelAttribute("languagesKnown")
	public Set<String> showLanguages() {
		Set<String> languages = service.getSetOfLanguages();
		return languages;
	}

	@ModelAttribute("things")
	public Set<String> showItems() {
		Set<String> items = service.getListOfItems();

		return items;
	}
}
