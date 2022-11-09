package com.hand.spring;

import com.hand.spring.entity.Cat;
import com.hand.spring.entity.Dog;
import com.hand.spring.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {

    @Test
    public void personTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("personBeans.xml");
        Person person = context.getBean("person", Person.class);
        Cat cat = person.getCat();
        if (null == cat) {
            System.out.println("Ooooops cat lost!");
            return;
        }
        cat.bark();
        Dog dog = person.getDog();
        if (null == dog) {
            System.out.println("Ooooops dog lost!");
            return;
        }
        dog.bark();
        System.out.println("Cat's name --------> " + cat.getName());
        System.out.println("Dog's name --------> " + dog.getName());
    }

    @Test
    public void personTest_2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("personBeans.xml");
        Person person = context.getBean("person2", Person.class);
        Cat cat = person.getCat();
        if (null == cat) {
            System.out.println("Ooooops cat lost!");
            return;
        }
        cat.bark();
        Dog dog = person.getDog();
        if (null == dog) {
            System.out.println("Ooooops dog lost!");
            return;
        }
        dog.bark();
        System.out.println("Cat's name --------> " + cat.getName());
        System.out.println("Dog's name --------> " + dog.getName());
    }
}
