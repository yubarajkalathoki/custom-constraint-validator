package com.yubaraj.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validator that actually adds logic to validate jComboBox.
 * 
 * @author Yuba Raj Kalathoki
 * @since 0.1.0
 */
public class QuestionRequiredValidator implements ConstraintValidator<QuestionRequired, String> {

	private String value;

	@Override
	public void initialize(QuestionRequired arg0) {
		this.value = QuestionRequired.value;

	}

	@Override
	public boolean isValid(String question, ConstraintValidatorContext arg1) {
		if (question.equalsIgnoreCase(value)) {
			return false;
		}
		return true;
	}
}
