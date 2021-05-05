package com.hyperleon.thinking.spring.ioc.container.dependency.container;

import com.hyperleon.thinking.spring.ioc.container.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author leon
 * @date 2021-05-05 11:30
 **/
public class BeanFactoryAsIocContainer {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        int i = reader.loadBeanDefinitions("META-INF/dependency-lookup-context.xml");
        System.out.println("load bean count: " + i);
        lookupByCollectionType(beanFactory);
    }

    public static void lookupByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(beansOfType);
        }
    }
}
