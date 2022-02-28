package com.hyperleon.thinking.spring.validation;

import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Locale;

/**
 * @author leon
 * @date 2022-02-28 22:49
 **/
public class ErrorMessageDemo {

    public static void main(String[] args) {
        Bar bar = new Bar();
        BeanPropertyBindingResult errors = new BeanPropertyBindingResult(bar, "bar");
        errors.reject("bar.properties.not.null");
        errors.rejectValue("name","name.required");

        List<ObjectError> globalErrors = errors.getGlobalErrors();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        List<ObjectError> allErrors = errors.getAllErrors();

        MessageSource messageSource = createMessageSource();

        allErrors.forEach(allError -> {
            String message = messageSource.getMessage(allError.getCode(), allError.getArguments(), Locale.getDefault());
            System.out.println(message);
        });
    }

    public static MessageSource createMessageSource() {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("bar.properties.not.null",Locale.getDefault(),"bar 的所有属性不能为空");
        messageSource.addMessage("name.required", Locale.getDefault(), "the name if bar must not be null");
        return messageSource;

    }
}
