package com.nt.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.entity.StudentInfo;

@Component
public class StudentValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {

		return clazz.isAssignableFrom(StudentInfo.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		StudentInfo stud = (StudentInfo) target;
		if (stud.getName() == null || stud.getName().isBlank()) {
			errors.rejectValue("name", "stud.name.required");// here string 1st value is our wish
		} else if (stud.getName().length() < 6 || stud.getName().length() > 20) {
			errors.rejectValue("name", "stud.name.length");
		}
		if (stud.getCourse() == null || stud.getCourse().isBlank()) {
			errors.rejectValue("course", "stud.course.required");
		} else if (stud.getCourse().length() < 6 || stud.getCourse().length() > 20) {
			errors.rejectValue("course", "stud.course.length");
		}
		if (stud.getAge() == null) {
			errors.rejectValue("age", "stud.age.required");
		} else if (((Float) stud.getAge().floatValue()).isNaN()) {
			errors.rejectValue("age", "stud.age.numeric");
		} else if (stud.getAge() < 20 || stud.getAge() > 30) {
			errors.rejectValue("age", "stud.age.range");
		}
		if (stud.getMobile() == null || stud.getMobile().isBlank()) {
			errors.rejectValue("mobile", "stud.mobile.required");
		} else if (stud.getMobile().length() != 10) {
			errors.rejectValue("mobile", "stud.mobile.length");
		}
		if (stud.getFees() == null) {
			errors.rejectValue("fees", "stud.fees.required");
		} else if (((Float) stud.getFees().floatValue()).isNaN()) {
			errors.rejectValue("fees", "stud.fees.numeric");
		} else if (stud.getFees() < 10000 || stud.getFees() > 50000) {
			errors.rejectValue("fees", "stud.fees.range");
		}
	}

}
