package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.repo.CustomEmployeeRepository;
import com.nt.service.IEmpMgmtService;
import com.nt.validator.EmployeeValidatorClass;

@Controller("empController")
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmpMgmtService service;

	@Autowired
	private CustomEmployeeRepository empRepo;

	@Autowired
	private EmployeeValidatorClass validator;

	@GetMapping("/home")
	public String displayChanduSoftwareSolution() {
		return "shining_software_solutions";
	}

	@GetMapping("/employeeInfo")
	public String displayEmployeesInfo(Map<String, Object> map) {
		Iterable<Employee> employees = service.fetchAllEmployeeInfo();
		map.put("emps", employees);
		return "employee_details";
	}

	@GetMapping("/addEmp")
	public String addNewEmployeeDetials(@ModelAttribute("emp") Employee emp) {
		return "add_employee";
	}

	@PostMapping("/addEmp")
	public String registerNewEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes attri,
			BindingResult error) {
		if (validator.supports(emp.getClass())) {
			validator.validate(emp, error);

			if (error.hasErrors()) {
				return "add_employee";
			}

		}
		if (emp.getJob().equalsIgnoreCase("accountant") || emp.getJob().equalsIgnoreCase("sales man")) {
			error.rejectValue("job", "emp.job.reject");
			return "add_employee";
		}
		String result = service.registerEmployeeDetails(emp);
		attri.addFlashAttribute("message", result);
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
		if (emp.getActivate().equalsIgnoreCase("no")) {
			if (validator.supports(emp.getClass())) {
				validator.validate(emp, errors);
				if (errors.hasErrors()) {
					return "edit_employee";
				}
			}
			if (emp.getJob().equalsIgnoreCase("accountant") || emp.getJob().equalsIgnoreCase("sales man")) {
				errors.rejectValue("job", "emp.job.reject");
				return "edit_employee";
			}
		}
		String result = service.saveEditedEmpDetails(emp);
		attri.addFlashAttribute("message", result);
		return "redirect:employeeInfo";
	}

	@GetMapping("delete_emp")
	public String deleteEmpDetails(RedirectAttributes attri, @RequestParam("empno") Integer empno) {
		String msg = service.deleteEmployeByEmpno(empno);
		attri.addFlashAttribute("message", msg);
		return "redirect:employeeInfo";
	}

}
