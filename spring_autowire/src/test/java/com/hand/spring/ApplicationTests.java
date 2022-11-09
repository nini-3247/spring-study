package com.hand.spring;

import com.hand.spring.entity.Cat;
import com.hand.spring.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

class ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void forEachTest() {
        List<Cat> cats = new ArrayList<>(10);
        Cat cat1 = new Cat("kitty1");
        Cat cat2 = new Cat("kitty2");
        Cat cat3 = new Cat("kitty3");
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        System.out.println("before change ------> " + cats);

        cats.forEach((cat) -> {
            cat.setName("KITTY");
        });
        System.out.println("after change ------> " + cats);

        cats.forEach((cat) -> {
            System.out.println("second for-each ------> " + cat);
        });
    }

}
