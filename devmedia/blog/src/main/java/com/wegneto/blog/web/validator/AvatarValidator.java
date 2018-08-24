package com.wegneto.blog.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.wegneto.blog.entity.Avatar;

public class AvatarValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Avatar.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Avatar avatar = (Avatar) target;
		
		if (avatar.getFile() != null) {
			if (avatar.getFile().getSize() == 0) {
				errors.rejectValue("file", "file", "Selecione uma imagem de até 100kb.");
			}
		}
	}

}
