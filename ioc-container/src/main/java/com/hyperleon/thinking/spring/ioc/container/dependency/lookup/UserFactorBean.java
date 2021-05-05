package com.hyperleon.thinking.spring.ioc.container.dependency.lookup;

import com.hyperleon.thinking.spring.ioc.container.dependency.domain.User;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * @author leon
 * @date 2021-05-05 09:45
 **/
public class UserFactorBean extends AbstractFactoryBean<User> {

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    protected User createInstance() throws Exception {
        User user = new User();
        user.setAge(1);
        user.setName("factoryBeanUser");
        return user;
    }
}
