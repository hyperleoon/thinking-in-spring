package com.hyperleon.thinking.spring.bean.definition.initialization;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;

/**
 * @author leon
 * @date 2022-02-13 15:09
 **/
public class BeanInitializationDemo {

    public static void main(String[] args) {
        // 1. by @PostConstruct
        // 2. by initMethod
        // 3. by InitializingBean#afterPropertiesSet
        // 4. AbstractBeanDefinition.setInitMethodName

        // sort @PostConstruct-> InitializingBean#afterPropertiesSet-> initMethod

        AnnotationConfigApplicationContext  applicationContext0 = new AnnotationConfigApplicationContext();
        applicationContext0.register(BeanInitializationDemo.class);
        System.out.println("spring application context refresh...");
        applicationContext0.refresh();
        System.out.println("get bean action");
        System.out.println(applicationContext0.getBeansOfType(Foo.class));
        applicationContext0.close();


        // test lazyBean
        AnnotationConfigApplicationContext  applicationContext1 = new AnnotationConfigApplicationContext();
        applicationContext1.register(BeanInitializationDemo.class);
        System.out.println("spring application context refresh...");
        applicationContext1.refresh();
        System.out.println("get bean action");
        System.out.println(applicationContext1.getBeansOfType(LazyFoo.class));
        applicationContext1.close();
    }


    @Bean
    public Foo foo0() {
        return new Foo();
    }

    @Bean(initMethod = "initFoo")
    public Foo foo1() {
        return new Foo();
    }

    @Bean
    public Foo foo2() {
        return new Foo();
    }

    public static class Foo implements InitializingBean {
        private String name;

        @PostConstruct
        public void init() {
            System.out.println("begin init....");
            this.name = "by @PostConstruct";
        }

        @Override
        public String toString() {
            return "Foo{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public void initFoo() {
            this.name = "by initMethod";
        }


        @Override
        public void afterPropertiesSet() {
            this.name = "by InitializingBean";
        }
    }

    public static class LazyFoo{

        @PostConstruct
        public void init() {
            System.out.println("begin lazy init....");
        }
    }


    @Bean
    @Lazy
    public LazyFoo lazyFoo() {
        return new LazyFoo();
    }

}
