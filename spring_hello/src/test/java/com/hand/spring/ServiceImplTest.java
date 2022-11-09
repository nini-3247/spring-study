package com.hand.spring;

import com.hand.spring.service.HelloService;
import com.hand.spring.service.impl.HelloServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
public class ServiceImplTest {

    @Test
    public void beanXmlTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloServiceImpl serviceImpl = (HelloServiceImpl) context.getBean("HelloServiceImpl");
        serviceImpl.getHelloDao().showImpl();
    }

    @Test
    public void useSerInSerImplTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloServiceImpl serviceImpl = (HelloServiceImpl) context.getBean("HelloServiceImpl");
        HelloService service = serviceImpl.getHelloService();
        System.out.println(service);
    }

}
