package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.StudentInfo;
import com.nt.repo.CustomCollegeRepository;
import com.nt.service.ICollegeServiceMgmt;
import com.nt.validations.StudentValidator;

@Controller
public class CollegeController {
	@Autowired
	private ICollegeServiceMgmt collegeService;
	@Autowired
	private CustomCollegeRepository collegeRepo;
	@Autowired
	private StudentValidator validator;

	@GetMapping("/")
	public String collegeHomePage() {
		return "college_home";
	}
	/*
	 * @GetMapping("/student_report")
	 * public String displayStudentDetails(Map<String, Object> map) {
	 * Iterable<StudentInfo> StudInfo = collegeService.showStudentDetails();
	 * map.put("stud_data", StudInfo);
	 * return "student_report";
	 * }
	 */

	@GetMapping("/student_report")
	public String showStudentReportByPagination(
			@PageableDefault(page = 0, size = 3, sort = "name", direction = Sort.Direction.ASC) Pageable pageable,
			Map<String, Object> map) {
		Page<StudentInfo> page = collegeService.displayRecordsByPagination(pageable);
		map.put("pageData", page);
		return "student_report";
	}

	@GetMapping("/add_student")
	public String addNewStudent(@ModelAttribute("stud") StudentInfo sInfo) {
		return "student_form";
	}

	@PostMapping("/add_student")
	public String addNewStudent(@ModelAttribute("stud") StudentInfo sInfo, RedirectAttributes attri,
			BindingResult errors) {
		System.out.println(sInfo.getValidateFlag());
		if (sInfo.getValidateFlag().equalsIgnoreCase("no")) {
			if (validator.supports(sInfo.getClass())) {
				validator.validate(sInfo, errors);
				if (errors.hasErrors()) {

					return "student_form";
				}
			}
		}
		if (sInfo.getCourse() == "Oracle" || sInfo.getCourse() == "ReactJs") {
			errors.rejectValue("course", "stud.course.restriction");
		}

		String result = collegeService.addNewStudent(sInfo);
		attri.addFlashAttribute("message", result);
		return "redirect:student_report";
	}

	@GetMapping("/delete_student")
	public String deleteStudentInfo(@RequestParam("studentId") Integer studId, RedirectAttributes attri) {
		collegeRepo.deleteById(studId);
		String result = studId + ": student id is deleted successfully";
		attri.addFlashAttribute("message", result);
		return "redirect:student_report";
	}
}
