package com.hyperleon.thinking.spring.ioc.container.dependency.domain;

import com.hyperleon.thinking.spring.ioc.container.dependency.annotation.Super;

/**
 * @author leon
 * @date 2021-05-05 10:03
 **/
@Super
public class SuperUser extends User {

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "phone='" + phone + '\'' +
                '}';
    }
}
