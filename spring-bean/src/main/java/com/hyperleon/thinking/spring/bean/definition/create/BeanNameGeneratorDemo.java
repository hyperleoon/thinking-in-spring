package com.hyperleon.thinking.spring.bean.definition.create;

import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * @author leon
 * @date 2021-05-12 19:20
 **/
public class BeanNameGeneratorDemo {
    public static void main(String[] args) {
        BeanNameGenerator beanNameGenerator = new DefaultBeanNameGenerator();
        AnnotationBeanNameGenerator annotationBeanNameGenerator = new AnnotationBeanNameGenerator();
    }
}
