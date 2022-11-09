package com.hand.spring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class Person {
    private String name;
    /*
    Autowired注解：byType；若有多个类型相同的，可以结合@Qualifier，实现byName
    注意使用@Qualifier指定多个中的一个时，要去掉setter方法
     */
    @Autowired
    @Qualifier(value = "cat111")
    private Cat cat;
    /*
    Resource注解：jdk注解，11之后取消，先按照byName找（设置name属性），
    找不到再按照byType找
     */
    @Resource(name = "dog222")
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cat=" + cat +
                ", dog=" + dog +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat getCat() {
        return cat;
    }

    /*public void setCat(Cat cat) {
        this.cat = cat;
    }*/

    public Dog getDog() {
        return dog;
    }

    /*public void setDog(Dog dog) {
        this.dog = dog;
    }*/
}
