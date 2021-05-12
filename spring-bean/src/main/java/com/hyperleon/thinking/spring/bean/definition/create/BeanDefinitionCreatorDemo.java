package com.hyperleon.thinking.spring.bean.definition.create;

import com.hyperleon.thinking.spring.ioc.container.dependency.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;


/**
 * @author leon
 * @date 2021-05-12 19:06
 **/
public class BeanDefinitionCreatorDemo {
    public static void main(String[] args) {
        //1.Create bean by beanDefinitionBuilder
        //builder beanDefinition
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name","leon").addPropertyValue("age",24);
        //get instance
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println(beanDefinition);

        //2.Direct creat bean by BeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("name","leon").add("age",24);
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
        System.out.println(genericBeanDefinition);
    }
}
