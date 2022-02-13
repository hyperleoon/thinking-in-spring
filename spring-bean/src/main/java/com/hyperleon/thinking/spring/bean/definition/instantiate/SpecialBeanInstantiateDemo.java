package com.hyperleon.thinking.spring.bean.definition.instantiate;

import com.hyperleon.thinking.spring.bean.definition.instantiate.bean.DefaultUserFactory;
import com.hyperleon.thinking.spring.bean.definition.instantiate.bean.UserFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceListFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author leon
 * @date 2021-05-14 00:04
 **/
public class SpecialBeanInstantiateDemo {

    public static void main(String[] args) {
        // special types of instance bean
        // 1.by ServiceLoaderFactoryBean
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/special-bean-instantiate-context.xml");
        List<DefaultUserFactory> defaultUserFactories = beanFactory.getBean("userFactorServiceLoader", List.class);
        System.out.println(defaultUserFactories);

        testFromAnnotationRegister();

        // 2.by autowiredCapableBeanFactory
        AutowireCapableBeanFactory autowireCapableBeanFactory = new DefaultListableBeanFactory();
        DefaultUserFactory bean = autowireCapableBeanFactory.createBean(DefaultUserFactory.class);
        System.out.println(bean);
    }

    public static void testFromAnnotationRegister() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.registerBean(SpecialBeanInstantiateDemo.class);
        applicationContext.refresh();
        List<UserFactory> userFactorServiceLoader = applicationContext.getBean("userFactorServiceLoader", List.class);
        System.out.println(userFactorServiceLoader);
        applicationContext.close();
    }

    @Bean("userFactorServiceLoader")
    public ServiceListFactoryBean serviceListFactoryBean() {
        ServiceListFactoryBean serviceListFactoryBean = new ServiceListFactoryBean();
        serviceListFactoryBean.setServiceType(UserFactory.class);
        return serviceListFactoryBean;
    }

}
