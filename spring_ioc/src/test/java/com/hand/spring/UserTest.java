package com.hand.spring;

import com.hand.spring.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user5");
        System.out.println(user.toString());
    }

    @Test
    public void test_equals() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user1 = (User) context.getBean("user");
        User user2 = (User) context.getBean("user");
        System.out.println("user1: " + user1);
        System.out.println("user2: " + user2);
        System.out.println("HashCode-user1: " + user1.hashCode());
        System.out.println("HashCode-user2: " + user2.hashCode());
        System.out.println("==: " + (user1 == user2));
        System.out.println("equals: " + (user1.equals(user2)));
    }

    @Test
    public void test_equals_2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        User user1 = (User) context.getBean("user3");
        User user2 = (User) context.getBean("user3");
        System.out.println("user1: " + user1);
        System.out.println("user2: " + user2);
        System.out.println("HashCode-user1: " + user1.hashCode());
        System.out.println("HashCode-user2: " + user2.hashCode());
        System.out.println("==: " + (user1 == user2));
        System.out.println("equals: " + (user1.equals(user2)));
    }
}
