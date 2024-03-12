package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.repo.CustomEmployeeRepository;
import com.nt.service.IEmpMgmtService;
import com.nt.validations.EmployeeValidator;

@Controller("empController")
public class EmployeeController {
	@Autowired
	private IEmpMgmtService service;
	@Autowired
	private EmployeeValidator validator;
	@Autowired
	private CustomEmployeeRepository empRepo;

	@GetMapping("/")
	public String displayChanduSoftwareSolution() {
		return "shining_software_solutions";
	}

	@GetMapping("/employeeInfo")
	public String displayEmployeesInfo(Map<String, Object> map) {
		Iterable<Employee> employees = service.fetchAllEmployeeInfo();
		map.put("emps", employees);
		return "employee_details";
	}

	// pagination and sorting
	/*
	 * @GetMapping("/employeeInfo")
	 * public String displayEmpsInfoByPagination(
	 * 
	 * @PageableDefault(size = 3, page = 0, direction = Sort.Direction.ASC, sort =
	 * "ename") Pageable pageable,
	 * Map<String, Object> map) {
	 * Page<Employee> page = service.fetchAllEmpsInfoByPagination(pageable);
	 * map.put("pageData", page);
	 * return "employee_details";
	 * }
	 */

	@GetMapping("/addEmp")
	public String addNewEmployeeDetials(@ModelAttribute("emp") Employee emp) {
		return "add_employee";
	}

	@PostMapping("/addEmp")
	public String registerNewEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes attri,
			BindingResult errors) {

		if (validator.supports(emp.getClass())) {
			validator.validate(emp, errors);
			if (errors.hasErrors()) {
				return "add_employee";
			}
		}
		String result = service.registerEmployeeDetails(emp);
		attri.addAttribute("message", result);
		return "redirect:employeeInfo";
	}

	@GetMapping("/edit_emp")
	public String displayEmployeeDetailsByName(@ModelAttribute("emp") Employee emp, @RequestParam Integer empno) {
		Employee empInfo = service.fetchEmployeeDetailsByEmpno(empno);
		BeanUtils.copyProperties(empInfo, emp);
		return "edit_employee";
	}

	@PostMapping("/edit_emp")
	public String saveNewEmpDetails(@ModelAttribute("emp") Employee emp, RedirectAttributes attri,
			BindingResult errors) {
		if (validator.supports(emp.getClass())) {
			validator.validate(emp, errors);
			if (errors.hasErrors()) {
				return "edit_employee";
			}

		}
		String result = service.saveEditedEmpDetails(emp);
		attri.addFlashAttribute("message", result);
		return "redirect:employeeInfo";
	}

	@GetMapping("delete_emp")
	public String deleteEmpDetails(@RequestParam Integer empno, RedirectAttributes attri) {
		empRepo.deleteById(empno);
		String userMessage = empno + ":Id Details are in inActive mode";
		attri.addFlashAttribute("message", userMessage);
		return "redirect:employeeInfo";
	}
}
