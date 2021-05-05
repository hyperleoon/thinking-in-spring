package com.hyperleon.thinking.spring.ioc.container.dependency.injection;

import com.hyperleon.thinking.spring.ioc.container.dependency.annotation.Super;
import com.hyperleon.thinking.spring.ioc.container.dependency.domain.User;
import com.hyperleon.thinking.spring.ioc.container.dependency.lookup.UserFactorBean;
import com.hyperleon.thinking.spring.ioc.container.dependency.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author leon
 * @date 2021-05-05 09:28
 **/
public class DependencyInjectDemo {

    public static void main(String[] args)  {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-inject-context.xml");
        lookupByName(beanFactory);
    }

    public static void lookupByName(BeanFactory beanFactory)  {
        UserRepository userRepository = (UserRepository)beanFactory.getBean("userRepository");
        System.out.println(userRepository);

        ObjectFactory<ApplicationContext> objectFactory = userRepository.getObjectFactory();
        ApplicationContext applicationContext = objectFactory.getObject();
        System.out.println(applicationContext == beanFactory);

        System.out.println(applicationContext);
        System.out.println(beanFactory);
        System.out.println(userRepository.getBeanFactory());
    }

}
