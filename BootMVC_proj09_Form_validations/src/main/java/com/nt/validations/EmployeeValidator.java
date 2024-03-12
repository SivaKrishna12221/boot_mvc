package com.nt.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.entity.Employee;

@Component
public class EmployeeValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {// here class object is nothing modelAttibute

		return clazz.isAssignableFrom(Employee.class);// passing class object same to the Employee.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate()");
		Employee emp = (Employee) target;
		if (emp.getEmpno() == null) {
			errors.rejectValue("empno", "emp.empno.required");

		} else if (((Float) emp.getEmpno().floatValue()).isNaN()) {
			errors.rejectValue("empno", "emp.empno.numeric");
		}

		else if (emp.getEmpno() < 4000 || emp.getEmpno() > 6000) {
			errors.rejectValue("empno", "emp.empno.range");
		}

		if (emp.getEname() == null || emp.getEname().isBlank()) {
			errors.rejectValue("ename", "emp.ename.required");
		} else if (emp.getEname().length() < 6) {
			errors.rejectValue("ename", "emp.ename.minlength");
		}
		if (emp.getJob() == null || emp.getJob().isEmpty()) {
			errors.rejectValue("job", "emp.job.required");
		} else if (emp.getJob().length() < 6) {
			errors.rejectValue("job", "emp.job.minlength");
		}
		if (emp.getSal() == null) {
			errors.rejectValue("sal", "emp.sal.required");

		} else if (emp.getSal().isNaN()) {
			errors.rejectValue("sal", "emp.sal.numeric");
		} else if (emp.getSal() < 3000 || emp.getSal() > 10000) {
			errors.rejectValue("sal", "emp.sal.range");
		}

		if (emp.getDeptno() == null) {
			errors.rejectValue("deptno", "emp.deptno.required");
		} else if (((Float) emp.getDeptno().floatValue()).isNaN()) {
			errors.rejectValue("deptno", "emp.deptno.numeric");
		} else if (emp.getDeptno() < 10 && emp.getDeptno() > 100) {
			errors.rejectValue("deptno", "emp.deptno.range");
		}

	}

}
