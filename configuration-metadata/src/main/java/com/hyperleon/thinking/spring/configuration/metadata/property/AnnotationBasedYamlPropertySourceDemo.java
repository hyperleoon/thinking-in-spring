package com.hyperleon.thinking.spring.configuration.metadata.property;

import com.hyperleon.thinking.spring.configuration.metadata.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MutablePropertySources;

/**
 * @author leon
 * @date 2022-02-26 23:08
 **/
@PropertySource(
        name = "yamlPropertySource",
        value = "classpath:/META-INF/user.yaml",
        factory = YamlPropertySourceFactory.class)
public class AnnotationBasedYamlPropertySourceDemo {

    @Bean
    public User user(@Value("${user.id}") Long id, @Value("${user.name}") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationBasedYamlPropertySourceDemo.class);
        context.refresh();

        MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
        boolean yamlPropertySource = propertySources.contains("yamlPropertySource");
        System.out.println(yamlPropertySource);

        User bean = context.getBean(User.class);
        System.out.println(bean);

        context.close();
    }
}
