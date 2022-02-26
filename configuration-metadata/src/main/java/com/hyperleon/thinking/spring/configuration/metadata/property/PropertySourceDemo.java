package com.hyperleon.thinking.spring.configuration.metadata.property;

import com.hyperleon.thinking.spring.configuration.metadata.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leon
 * @date 2022-02-26 22:40
 **/
@PropertySource("classpath:/META-INF/user.properties")
public class PropertySourceDemo {

    @Bean
    public User user(@Value("${user.id}") Long id, @Value("${user.name}") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //
        Map<String, Object> propertiesSource = new HashMap<>();
        propertiesSource.put("user.name","fakeLeon");

        org.springframework.core.env.PropertySource mapPropertySource = new MapPropertySource("first-property-soruce", propertiesSource);
        context.getEnvironment().getPropertySources().addFirst(mapPropertySource);

        context.register(PropertySourceDemo.class);
        context.refresh();

        User bean = context.getBean(User.class);
        System.out.println(bean);


        context.close();
    }
}
