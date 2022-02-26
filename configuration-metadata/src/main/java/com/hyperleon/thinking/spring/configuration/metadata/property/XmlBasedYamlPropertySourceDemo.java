package com.hyperleon.thinking.spring.configuration.metadata.property;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author leon
 * @date 2022-02-26 22:58
 **/
public class XmlBasedYamlPropertySourceDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        reader.loadBeanDefinitions("META-INF/yaml-user-context.xml");

        Map<String,Object> bean = beanFactory.getBean("yamlMap", Map.class);

        System.out.println(bean);
    }
}
