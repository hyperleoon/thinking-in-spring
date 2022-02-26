package com.hyperleon.thinking.spring.ioc.dependency.injection.lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author leon
 * @date 2022-02-21 08:47
 **/
public class LazyInjectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {

        });
    }
}
