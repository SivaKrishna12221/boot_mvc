package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.entity.StudentInfo;
import com.nt.service.IStudentService;

@Controller
public class BeanNameViewResolverForPdfAndExcelController {

	@Autowired
	private IStudentService studService;

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}

	@GetMapping("/report")
	public String displayStudentInfoEitherExcelAndPdf(@RequestParam("type") String type,
			@ModelAttribute("sInfo") StudentInfo info,
			@PageableDefault(size = 10, page = 0, sort = "studName", direction = Sort.Direction.ASC) Pageable pageable,
			Map<String, Object> map) {
		Page<StudentInfo> page = studService.fetchAllStudentInfo(pageable);
		List<StudentInfo> list = page.getContent();
		list.forEach(System.out::println);
		map.put("studData", page);
		if (type.equalsIgnoreCase("pdf")) {
			return "stud_pdf_report";
		} else {
			return "excel_stud_info";
		}
	}

}
