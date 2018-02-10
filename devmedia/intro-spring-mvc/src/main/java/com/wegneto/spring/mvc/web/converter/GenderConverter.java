package com.wegneto.spring.mvc.web.converter;

import org.springframework.core.convert.converter.Converter;

import com.wegneto.spring.mvc.domain.Gender;

public class GenderConverter implements Converter<String, Gender> {

	@Override
	public Gender convert(String value) {
		return value.charAt(0) == Gender.MALE.getDescription() ? Gender.MALE : Gender.FEMALE;
	}

}
