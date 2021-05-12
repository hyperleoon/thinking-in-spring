package com.hyperleon.thinking.spring.bean.definition.register;

import com.hyperleon.thinking.spring.ioc.container.dependency.domain.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

/**
 * @author leon
 * @date 2021-05-12 19:49
 **/
public class RegisterBeanDefinitionByApi {

    public static void main(String[] args) {
        //Two way of register bean by api
        // (1) with bean name : BeanDefinitionRegistry#registerBeanDefinition
        // (2) without bean name : BeanDefinitionReaderUtils#registerWithGeneratedName
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        registerBean(applicationContext,"leonBean");
        registerBean(applicationContext,null);
        applicationContext.refresh();
        System.out.println("all user bean:" + applicationContext.getBeansOfType(User.class));
        applicationContext.close();
    }


    public static void registerBean(BeanDefinitionRegistry registry,String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("name", "leon")
                .addPropertyValue("age", 24);
        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }
    }
}
