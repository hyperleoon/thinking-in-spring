package com.hyperleon.thinking.spring.conversion;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.Properties;

/**
 * @author leon
 * @date 2022-03-02 23:08
 **/
public class CustomizedPropertyEditorRegister implements PropertyEditorRegistrar , BeanFactoryPostProcessor {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Bar.class, "context", new StringToPropertiesPropertyEditor());

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.addPropertyEditorRegistrar(this);
    }

    static class StringToPropertiesPropertyEditor extends PropertyEditorSupport {

        @Override
        public String getAsText() {
            Properties properties = (Properties) getValue();
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append(System.getProperty("line.separator"));
            }

            return stringBuilder.toString();
        }

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Properties properties = new Properties();
            try {
                properties.load(new StringReader(text));
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }

            setValue(properties);
        }
    }
}

