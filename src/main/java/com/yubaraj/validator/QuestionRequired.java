package com.yubaraj.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = QuestionRequiredValidator.class)
@Documented
public @interface QuestionRequired {
	String value = "Security questions";

	String message() default "Please select a scurity question.";

	Class<?>[]groups() default {};

	Class<? extends Payload>[]payload() default {};
}
