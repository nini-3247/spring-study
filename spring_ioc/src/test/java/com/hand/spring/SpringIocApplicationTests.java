package com.hand.spring;

import com.hand.spring.entity.User2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringIocApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testConstructor() {
        User2 user = new User2();
        System.out.println(user);
    }

    @Test
    public void testConstructor_2() {
        User2 user = new User2("cjh", "lovRDJ3000");
        System.out.println(user);
    }
}
