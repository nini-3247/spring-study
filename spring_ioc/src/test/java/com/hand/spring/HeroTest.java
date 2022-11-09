package com.hand.spring;

import com.hand.spring.entity.Hero;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HeroTest {

    @Test
    public void test_1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hero tonyStark = (Hero) context.getBean("TonyStark");
        System.out.println(tonyStark.toString());
    }
}
