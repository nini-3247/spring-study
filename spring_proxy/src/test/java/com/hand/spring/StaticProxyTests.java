package com.hand.spring;

import com.hand.spring.proxy.entity.User;
import com.hand.spring.proxy.static_.rent.Client;
import com.hand.spring.proxy.static_.rent.Intermediary;
import com.hand.spring.proxy.static_.rent.Tenant;
import com.hand.spring.proxy.static_.service.UserService;
import com.hand.spring.proxy.static_.service.UserServiceImpl;
import com.hand.spring.proxy.static_.service.UserServiceProxy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.image.RenderedImage;

class StaticProxyTests {

    /*
    传统做法：调用实现类方法，如果有对于每个方法的更改，只能到每个方法内部去更改
     */
    @Test
    public void staticServiceProxyTest_1() {
        User user = new User("cjh", 18);
        UserServiceImpl impl = new UserServiceImpl();
        impl.add(user);
        impl.update(user);
        impl.delete(user);
    }

    /*
    静态代理：有一个实现类就要写一个代理类；
        再代理类中设置一个私有变量，让实现类的对象作为一个参数放入代理类；
        在代理类中统一对每个方法进行修改；
        未减少代码修改量，但是统一处理，而且符合程序设计的开闭原则
     */
    @Test
    public void staticServiceProxyTest_2() {
        User user = new User("cjh", 18);
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserServiceImpl(new UserServiceImpl());
        proxy.add(user);
        proxy.update(user);
        proxy.delete(user);
    }

    /*
    租房场景：无代理情况——租户直接和房东租房
     */
    @Test
    public void staticRentProxyTest_1() {
        Client client = new Client("cjh");
        Tenant tenant = new Tenant("robert");
        client.rentFrom(tenant);
    }

    /*
    租房场景：静态代理——中介帮租房，将房东作为参数传入，
        在原有方法上添加看房、收中介费等方法
     */
    @Test
    public void staticRentProxyTest_2() {
        Client client = new Client("cjh");
        Tenant tenant = new Tenant("robert");
        Intermediary intermediary = new Intermediary();
        intermediary.setTenant(tenant);
        client.rentFrom(intermediary);
    }

}
