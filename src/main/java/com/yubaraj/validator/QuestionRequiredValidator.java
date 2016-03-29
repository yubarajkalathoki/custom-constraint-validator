package com.yubaraj.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class QuestionRequiredValidator implements ConstraintValidator<QuestionRequired, String> {

	private String value;

	@Override
	public void initialize(QuestionRequired arg0) {
		this.value = arg0.value;

	}

	@Override
	public boolean isValid(String question, ConstraintValidatorContext arg1) {
		if(question.equalsIgnoreCase(value)){
			return false;
		}
		return true;
	}
}
