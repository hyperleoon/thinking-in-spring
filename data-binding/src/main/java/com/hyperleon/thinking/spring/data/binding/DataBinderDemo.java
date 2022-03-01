package com.hyperleon.thinking.spring.data.binding;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leon
 * @date 2022-03-01 08:15
 **/
public class DataBinderDemo {

    public static void main(String[] args) {
        Foo foo = new Foo();
        DataBinder dataBinder = new DataBinder(foo, "foo");

        // propertyValues
        Map<String, Object> source = new HashMap<>();
        source.put("name", "leon");
        // dataBinder 忽略未知的属性
        source.put("age", 18);
        // dataBinder 处理嵌套属性
        source.put("company.id",1L);

        PropertyValues propertyValues = new MutablePropertyValues(source);

          // set
//        dataBinder.setIgnoreInvalidFields(false);
//        dataBinder.setAutoGrowNestedPaths(false);
//        dataBinder.setIgnoreInvalidFields(true);
//        dataBinder.setRequiredFields("name","company");

        // get
        BindingResult bindingResult = dataBinder.getBindingResult();


        // bind
        dataBinder.bind(propertyValues);

        System.out.println(foo);
    }


    static class Foo {
        private String name;

        private Company company;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

        @Override
        public String toString() {
            return "Foo{" +
                    "name='" + name + '\'' +
                    ", company=" + company +
                    '}';
        }
    }


    static class Company {
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Company{" +
                    "id=" + id +
                    '}';
        }
    }


}
