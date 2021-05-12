package com.hyperleon.thinking.spring.bean.definition.register;

import com.hyperleon.thinking.spring.ioc.container.dependency.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author leon
 * @date 2021-05-12 19:43
 **/
@Import(RegisterBeanDefinitionByAnnotation.Config.class)
public class RegisterBeanDefinitionByAnnotation {

    public static void main(String[] args) {
        //three way of register bean by annotation
        //  (1).by @Import
        //  (2).by @Component
        //  (3).by @Bean
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.registerBean(RegisterBeanDefinitionByAnnotation.class);
        applicationContext.refresh();
        System.out.println("register user bean:" + applicationContext.getBeansOfType(User.class));
        System.out.println("register config bean:" + applicationContext.getBeansOfType(Config.class));
        applicationContext.close();
    }


    @Component
    static class Config {

        @Bean
        public User user() {
            return new User();
        }
    }
}
