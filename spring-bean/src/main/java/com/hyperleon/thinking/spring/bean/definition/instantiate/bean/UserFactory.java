package com.hyperleon.thinking.spring.bean.definition.instantiate.bean;

import com.hyperleon.thinking.spring.ioc.container.dependency.domain.User;

/**
 * @author leon
 * @date 2021-05-13 23:48
 **/
public interface UserFactory {

    /**
     * obtain user
     * @return {@link User}
     */
    default User createUser() {return new User();}
}
