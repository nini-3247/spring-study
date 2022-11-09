package com.hand.spring.config;

import com.hand.spring.entity.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
@Configuration：说明是配置类，在其中可以实现spring的配置；相当于在xml中配置
@ComponentScan: 需要配合@Component使用，否则找不到包
用@Component和@Bean创建出来的对象不同
 */
@Configuration
@ComponentScan(basePackages = "com.hand.spring.entity")
public class BeanConfig {

    /*
    @Bean: 向spring容器注册bean，相当于在xml中配置<bean>，id即是方法名
     */
    @Bean
    public Book getBookBean() {
        return new Book();
    }
}
