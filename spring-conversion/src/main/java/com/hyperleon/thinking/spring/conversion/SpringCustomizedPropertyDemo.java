package com.hyperleon.thinking.spring.conversion;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author leon
 * @date 2022-03-02 23:27
 **/
public class SpringCustomizedPropertyDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/property-editors-context.xml");
        applicationContext.refresh();
        Bar bar = applicationContext.getBean("bar", Bar.class);
        System.out.println(bar);
        applicationContext.close();
    }
}
