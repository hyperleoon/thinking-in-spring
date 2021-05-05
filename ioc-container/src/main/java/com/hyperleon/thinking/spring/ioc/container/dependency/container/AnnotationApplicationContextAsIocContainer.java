package com.hyperleon.thinking.spring.ioc.container.dependency.container;

import com.hyperleon.thinking.spring.ioc.container.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @author leon
 * @date 2021-05-05 11:35
 **/
public class AnnotationApplicationContextAsIocContainer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationApplicationContextAsIocContainer.class);
        applicationContext.refresh();
        lookupByCollectionType(applicationContext);
        applicationContext.close();
    }

    public static void lookupByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(beansOfType);
        }
    }

    @Bean
    public User user() {
        User user = new User();
        user.setName("annotation user");
        return user;
    }
}
