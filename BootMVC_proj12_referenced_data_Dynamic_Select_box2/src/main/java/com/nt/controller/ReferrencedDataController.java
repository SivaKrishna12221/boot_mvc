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

import com.nt.model.StudentInfo;
import com.nt.service.IStudentMgmtService;

@Controller
public class ReferrencedDataController {

	@Autowired
	private IStudentMgmtService service;

	@GetMapping("/")
	public String showStudentForm() {
		return "student_home";
	}

	@GetMapping("/register")

	public String studentRegistration(@ModelAttribute("sinfo") StudentInfo sinfo) {
		return "student_form";
	}

	@ModelAttribute("countries")
	public Set<String> showListOfCountries() {
		return service.getListOfCountries();
	}

	@PostMapping("/states")
	public String getListOfStates(@RequestParam("country") String country, Map<String, Object> map,
			@ModelAttribute("sinfo") StudentInfo sinfo) {
		System.out.println("ReferrencedDataController.getListOfStates()" + country);

		Set<String> states = service.getListOfStates(country);
		states.forEach(System.out::println);
		map.put("states", states);
		return "student_form";
	}

	@PostMapping("/districts")
	public String getListOfDistricts(@RequestParam("district") String district,
			@ModelAttribute("sinfo") StudentInfo sinfo, Map<String, Object> map) {
		List<String> districts = service.getListOfDistricts(district);
		map.put("districts", districts);
		return "student_form";

	}

	@PostMapping("/mandals")
	public String getListOfMandals(@RequestParam("mandal") String mandal, @ModelAttribute("sinfo") StudentInfo sinfo,
			Map<String, Object> map) {
		List<String> mandals = service.getListOfMondals(mandal);
		map.put("mandals", mandals);
		return "student_form";
	}
}
