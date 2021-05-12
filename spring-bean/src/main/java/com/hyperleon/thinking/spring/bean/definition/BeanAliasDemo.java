package com.hyperleon.thinking.spring.bean.definition;

import com.hyperleon.thinking.spring.ioc.container.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author leon
 * @date 2021-05-12 19:29
 **/
public class BeanAliasDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/spring-beans-context.xml");
        User leon = beanFactory.getBean("leon-user", User.class);
        User user = beanFactory.getBean("user", User.class);
        System.out.println("alias equals origin?:" + (leon == user));
    }
}
