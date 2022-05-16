package com.wegneto.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String[] coursePrefixes;

	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefixes = courseCode.values();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value != null) {
			for (String prefix : coursePrefixes) {
				if (value.startsWith(prefix)) {
					return true;
				}
			}
		}
		
		return false;
	}

}
