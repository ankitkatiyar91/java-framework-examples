package com.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.constraints.Email;

public class EmailValidator implements ConstraintValidator<Email, String> {

	public String email;

	public void initialize(Email arg0) {
	}

	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		System.out.println("EmailValidator.isValid() " + arg0);
		if (arg0 != null) {
			if (arg0.endsWith("gmail.com")) {
				return true;
			}
		}
		return false;
	}

}
