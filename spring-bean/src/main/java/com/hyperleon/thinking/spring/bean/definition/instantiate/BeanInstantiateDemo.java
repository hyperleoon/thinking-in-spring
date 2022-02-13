package com.hyperleon.thinking.spring.bean.definition.instantiate;

import com.hyperleon.thinking.spring.ioc.container.dependency.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author leon
 * @date 2021-05-13 23:44
 **/
public class BeanInstantiateDemo {

    public static void main(String[] args) {
        // ways of instantiate bean
        // 1.by static method
        // 2.by factory
        // 3.by factory bean
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/bean-instantiate-context.xml");
        User beanByStaticMethod = applicationContext.getBean("user-by-static-method",User.class);
        System.out.println(beanByStaticMethod);
        User beanByFactor = applicationContext.getBean("user-by-factor", User.class);
        System.out.println(beanByFactor);
        User beanByFactorBean = applicationContext.getBean("user-by-factory-bean", User.class);
        System.out.println(beanByFactorBean);
    }
}
