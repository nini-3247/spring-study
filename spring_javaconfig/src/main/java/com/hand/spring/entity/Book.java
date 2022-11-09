package com.hand.spring.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
@Component: 此类被spring接管，注册到容器中
可以用类名小写驼峰获得该bean
 */
@Component
public class Book {

    private String name;

    public String getName() {
        return name;
    }

    @Value("三体")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
