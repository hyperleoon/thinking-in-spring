package com.hyperleon.thinking.spring.conversion;

import java.util.Properties;

/**
 * @author leon
 * @date 2022-03-02 23:36
 **/
public class Bar {

    private Properties context;

    public Properties getContext() {
        return context;
    }

    public void setContext(Properties context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "context=" + context +
                '}';
    }
}
