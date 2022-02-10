package com.hyperleon.thinking.spring.java.beans;

import com.hyperleon.thinking.spring.java.beans.beans.Person;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @author leon
 * @date 2021-05-04 21:24
 **/
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        Stream.of(propertyDescriptors).forEach((descriptor) -> {
            System.out.println(descriptor);
            Class<?> propertyType = descriptor.getPropertyType();
            if ("age".equals(descriptor.getName())) {
                descriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
            }
        });
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            setValue(Integer.valueOf(text));
        }
    }
}
