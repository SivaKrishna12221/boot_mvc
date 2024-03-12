package com.nit.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.Model.StudentInfo;

@Controller
public class DataBindingController {
	@GetMapping("/student_info")
	public String showStudentHomePage() {
		return "student_info";
	}

	@PostMapping("/student_info")
	public String registerStudentDetails(Map<String, Object> map, @ModelAttribute("sInfo") StudentInfo sInfo) {
		/* map.put("studentData", sInfo); */
		System.out.println(sInfo);
		return "result";
	}
}
