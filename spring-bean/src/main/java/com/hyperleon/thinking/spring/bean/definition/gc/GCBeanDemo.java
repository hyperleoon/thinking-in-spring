package com.hyperleon.thinking.spring.bean.definition.gc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

/**
 * @author leon
 * @date 2022-02-13 15:56
 **/
public class GCBeanDemo {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext =  new AnnotationConfigApplicationContext();
        applicationContext.register(GCBeanDemo.class);
        applicationContext.refresh();
        System.out.println("spring application context close");
        applicationContext.close();
        System.gc();
        TimeUnit.SECONDS.sleep(5);

    }

    @Bean
    public GcTarget gcTarget() {
        return new GcTarget();
    }

    public static class GcTarget{
        @Override
        public void finalize() throws Throwable {
            System.out.println("begin first gc");
        }
    }
}
