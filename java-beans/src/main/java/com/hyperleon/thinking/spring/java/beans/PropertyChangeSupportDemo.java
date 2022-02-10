package com.hyperleon.thinking.spring.java.beans;

import com.hyperleon.thinking.spring.java.beans.beans.Bar;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author leon
 * @date 2022-02-10 23:05
 **/
public class PropertyChangeSupportDemo {

    public static void main(String[] args) {
        Bar bar = new Bar();
        bar.addPropertyChangeListener("name", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(evt);
            }
        });
        bar.setName("bar");
    }
}
