package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.entity.Employee;

@Component
public class EmployeeValidatorClass implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {

		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Employee emp = (Employee) target;
		if (emp.getEname() == null || emp.getEname().isBlank()) {
			errors.rejectValue("ename", "emp.ename.required");
		} else if (emp.getEname().length() < 6 || emp.getEname().length() > 20) {
			errors.rejectValue("ename", "emp.ename.length");
		}

		if (emp.getJob() == null || emp.getJob().isBlank()) {
			errors.rejectValue("job", "emp.job.required");
		} else if (emp.getJob().length() < 6 || emp.getJob().length() > 20) {
			errors.rejectValue("job", "emp.job.length");
		}

		if (emp.getSal() == null) {
			errors.rejectValue("sal", "emp.sal.required");
		} else if (emp.getSal() < 10000 || emp.getSal() > 50000) {
			errors.rejectValue("sal", "emp.sal.range");
		}
		if (emp.getDeptno() == null) {
			errors.rejectValue("deptno", "emp.deptno.required");
		} else if (emp.getDeptno() < 10 || emp.getDeptno() > 100) {
			errors.rejectValue("deptno", "emp.deptno.range");
		}
	}

}
