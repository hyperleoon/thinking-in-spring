package com.hyperleon.thinking.spring.resource;

import com.hyperleon.thinking.spring.resource.ext.ResourceUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

/**
 * @author leon
 * @date 2022-02-27 10:12
 **/
public class InjectingResourceDemo {

    @Value("classpath:/META-INF/default.properties")
    private Resource defaultResource;

    @Value("classpath*:/META-INF/*.properties")
    private Resource[] propertiesResources;

    @Value("${user.dir}")
    private String currentFilePath;

    @PostConstruct
    public void init() {
        System.out.println(ResourceUtil.readContent(defaultResource));
        System.out.println(currentFilePath);
        Stream.of(propertiesResources).map(ResourceUtil::readContent).forEach(System.out::println);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(InjectingResourceDemo.class);
        applicationContext.refresh();
        applicationContext.close();
    }
}
