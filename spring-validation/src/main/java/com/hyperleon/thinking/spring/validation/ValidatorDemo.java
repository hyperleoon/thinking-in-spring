package com.hyperleon.thinking.spring.validation;

import org.springframework.context.MessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Locale;

import static com.hyperleon.thinking.spring.validation.ErrorMessageDemo.createMessageSource;

/**
 * @author leon
 * @date 2022-02-28 23:00
 **/
public class ValidatorDemo {

    public static void main(String[] args) {
        Validator validator = new BarValidator();
        Bar bar = new Bar();
        System.out.println(validator.supports(bar.getClass()));
        Errors errors = new BeanPropertyBindingResult(bar, "bar");
        validator.validate(bar, errors);
        MessageSource messageSource = createMessageSource();
        List<ObjectError> allErrors = errors.getAllErrors();

        allErrors.forEach(allError -> {
            String message = messageSource.getMessage(allError.getCode(), allError.getArguments(), Locale.getDefault());
            System.out.println(message);
        });

    }

    static class BarValidator implements Validator {
        @Override
        public boolean supports(Class<?> clazz) {
            return Bar.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            Bar bar = (Bar) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
        }
    }

}
