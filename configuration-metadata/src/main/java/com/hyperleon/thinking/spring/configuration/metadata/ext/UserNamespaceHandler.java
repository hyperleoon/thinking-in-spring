package com.hyperleon.thinking.spring.configuration.metadata.ext;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author leon
 * @date 2022-02-26 22:10
 **/
public class UserNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
