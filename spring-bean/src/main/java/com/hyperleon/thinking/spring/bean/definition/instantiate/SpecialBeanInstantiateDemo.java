package com.hyperleon.thinking.spring.bean.definition.instantiate;

import com.hyperleon.thinking.spring.ioc.container.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author leon
 * @date 2021-05-14 00:04
 **/
public class SpecialBeanInstantiateDemo {

    public static void main(String[] args) {
        // special types of instance bean
        // 1.by ServiceLoaderFactoryBean
        // 2.
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/special-bean-instantiate-context.xml");
        List<DefaultUserFactory> defaultUserFactories = beanFactory.getBean("userFactorServiceLoader", List.class);
        System.out.println(defaultUserFactories);
    }
}
