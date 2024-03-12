package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.StudentInfo;

@Controller
public class MVCTagsDataBinding {
	@GetMapping("/dataBinding")
	public String showStudentInfoPage() {
		return "studentInfo";
	}

	@PostMapping("/studentRegister")
	public String processStudentInfo(@ModelAttribute("sInfo") StudentInfo sinfo) {
		return "editStudentInfo";
	}

	@PostMapping("/saveStudInfo")
	public String saveEditedData(Map<String, Object> map, @ModelAttribute("stuInfo") StudentInfo studInfo) {
		return "displayData";
	}
}
