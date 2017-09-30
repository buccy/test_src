package com.jusheng.jeeboot.system.config.validator;

import com.jusheng.jeeboot.utils.RegexUtils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;


@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValid.DateChecker.class)
@Documented
public @interface DateValid {

	String message() default "日期格式不正确.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	class DateChecker implements ConstraintValidator<DateValid, String> {

		@Override
		public void initialize(DateValid arg0) {
		}

		@Override
		public boolean isValid(String strValue,
				ConstraintValidatorContext context) {
			if (!RegexUtils.isNotEmptyIgnoreBlank(strValue)) {
				return true;
			}
			return RegexUtils.isDataFormat(strValue);
		}

	}
}
