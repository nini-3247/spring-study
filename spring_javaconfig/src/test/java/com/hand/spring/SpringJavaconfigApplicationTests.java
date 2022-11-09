package com.hand.spring;

import com.hand.spring.config.BeanConfig;
import com.hand.spring.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class SpringJavaconfigApplicationTests {

    @Autowired
    private Book book;

    @Test
    public void javaConfigTest_1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Book book = (Book) context.getBean("getBookBean");
        System.out.println(book.toString());
    }

    @Test
    public void javaConfigTest_2() {
        // 报错NoSuchBeanDefinitionException，因为未注入bean
//        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
//        Book book = (Book) context.getBean("getBookComponent");
        // 直接打印自动注入的bean
        // bean为null
        System.out.println(book);
    }

    @Test
    public void javaConfigTest_3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Book book = (Book) context.getBean("book");
        System.out.println(book.toString());
    }

    @Test
    public void javaConfigTest_4() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Book book = (Book) context.getBean("getBookBean");
        Book book2 = (Book) context.getBean("book");
        Book book3 = (Book) context.getBean("getBookBean");
        Book book4 = (Book) context.getBean("book");
        System.out.println(book.toString());
        System.out.println(book2.toString());
        // 判断两个对象是否是同一个bean
        System.out.println("book: " + book.hashCode());
        System.out.println("book2: " + book2.hashCode());
        // 判断新对象是否为同一个bean
        System.out.println("book3: " + book3.hashCode());
        System.out.println("book4: " + book4.hashCode());
    }
}
