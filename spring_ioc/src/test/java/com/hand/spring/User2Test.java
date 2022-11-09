package com.hand.spring;

import com.hand.spring.entity.User2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User2Test {
    @Test
    public void test_1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("user2Beans.xml");
        User2 user2 = context.getBean("user2_1", User2.class);
        System.out.println(user2);
    }

    @Test
    public void test_2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("user2Beans.xml");
        User2 user2 = context.getBean("user2_2", User2.class);
        System.out.println(user2);
    }
}
