package com.yubaraj.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Annotation to validate jComboBox.
 * 
 * @author Yuba Raj Kalathoki
 * @since 0.1.0
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ComboBoxValidator.class)
@Documented
public @interface ValidComboBox {
	String value = "Security questions";

	String message() default "Please select a scurity question.";

	Class<?>[]groups() default {};

	Class<? extends Payload>[]payload() default {};
}
