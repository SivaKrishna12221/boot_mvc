package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Investor;
import com.nt.service.IInvestorServiceMgmt;

@Controller
public class DynamicReferencedDataController {

	@Autowired
	private IInvestorServiceMgmt service;

	@GetMapping("/")
	public String syrProperties(@ModelAttribute("investor") Investor investor) {
		return "syr_properties";
	}

	@ModelAttribute("countries")
	public Set<String> getCountries() {
		return service.populateCountries();
	}

	@PostMapping("/states")
	public String getStatesOfcountry(@RequestParam("country") String country,
			@ModelAttribute("investor") Investor investor, Map<String, Object> map) {
		System.out.println("DynamicReferencedDataController.getStatesOfcountry()");

		List<String> statesInfo = service.populateStates(country);// key is passing
		statesInfo.forEach(System.out::println);
		map.put("statesOfCountry", statesInfo);
		return "syr_properties";
	}
}
