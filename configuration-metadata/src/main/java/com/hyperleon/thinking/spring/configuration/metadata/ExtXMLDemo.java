package com.hyperleon.thinking.spring.configuration.metadata;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author leon
 * @date 2022-02-26 22:19
 **/
public class ExtXMLDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        reader.loadBeanDefinitions("META-INF/user-context.xml");

        User bean = beanFactory.getBean(User.class);
        System.out.println(bean);
    }
}
