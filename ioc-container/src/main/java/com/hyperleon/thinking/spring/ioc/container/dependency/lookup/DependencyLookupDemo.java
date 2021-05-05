package com.hyperleon.thinking.spring.ioc.container.dependency.lookup;

import com.hyperleon.thinking.spring.ioc.container.dependency.annotation.Super;
import com.hyperleon.thinking.spring.ioc.container.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author leon
 * @date 2021-05-05 09:28
 **/
public class DependencyLookupDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        lookupByName(beanFactory);
        lookupLazy(beanFactory);
        lookupByFactorBean(beanFactory);
        lookupByType(beanFactory);
        lookupByCollectionType(beanFactory);
        lookupByAnnotationType(beanFactory);
    }

    public static void lookupByName(BeanFactory beanFactory) {
        User user = (User)beanFactory.getBean("user");
        System.out.println(user);
    }

    public static void lookupLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>)beanFactory.getBean("objectFactor");
        User user = objectFactory.getObject();
        System.out.println(user);
    }

    public static void lookupByFactorBean(BeanFactory beanFactory) {
        User userFactorBean = (User)beanFactory.getBean("userFactorBean");
        System.out.println(userFactorBean);
    }


    public static void lookupByType(BeanFactory beanFactory) {
        User userFactorBean = beanFactory.getBean(User.class);
        System.out.println(userFactorBean);

        ObjectFactory bean = beanFactory.getBean(ObjectFactory.class);
        System.out.println(bean);

        FactoryBean bean1 = beanFactory.getBean(UserFactorBean.class);
        System.out.println(bean1);
    }

    public static void lookupByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(beansOfType);
        }
    }

    public static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfAnnotation = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(beansOfAnnotation);
        }
    }

}
