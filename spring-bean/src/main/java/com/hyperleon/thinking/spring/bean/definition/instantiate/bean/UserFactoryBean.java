package com.hyperleon.thinking.spring.bean.definition.instantiate.bean;

import com.hyperleon.thinking.spring.ioc.container.dependency.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author leon
 * @date 2021-05-13 23:56
 **/
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
