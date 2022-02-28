package com.hyperleon.thinking.spring.validation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author leon
 * @date 2022-02-28 23:06
 **/
public class BeanValidationDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-validation-context.xml");
        Validator validator = context.getBean(Validator.class);
        System.out.println(validator instanceof LocalValidatorFactoryBean);

        FooProcessor fooProcessor = context.getBean(FooProcessor.class);
        fooProcessor.process(new Foo());

        context.close();
    }

    @Component
    @Validated
    static class FooProcessor {
        public void process(@Valid Foo foo) {
            System.out.println(foo);
        }
    }

    @Validated
    static class Foo {

        @NotNull
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
