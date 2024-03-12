package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.entity.StudentInfo;
import com.nt.service.IStudentService;

@Controller
public class PdfExcelDocumentController {

	@Autowired
	private IStudentService service;

	@GetMapping("/")
	public String showEmployeeHome() {
		return "emp_home";
	}

	@GetMapping("/employee_report")
	public String showEmployeeReport(Map<String, Object> map, @RequestParam("type") String type,
			@PageableDefault(page = 0, direction = Sort.Direction.ASC, sort = "studentId") Pageable pageable) {
		Page<StudentInfo> pageData = service.fetchAllStudentInfo(pageable);
		map.put("pageData", pageData);
		if (type.equalsIgnoreCase("pdf")) {
			return "pdfreport";
		} else
			return "excelreport";
	}
}
