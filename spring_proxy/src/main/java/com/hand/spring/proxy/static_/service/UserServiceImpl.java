package com.hand.spring.proxy.static_.service;

import com.hand.spring.proxy.entity.User;

public class UserServiceImpl implements UserService{
    @Override
    public void add(User user) {
        log("start debugging");
        System.out.println("add a User");
        System.out.println(user.toString());
    }

    @Override
    public void delete(User user) {
        log("start debugging");
        System.out.println("delete a User");
        System.out.println(user.toString());
    }

    @Override
    public void update(User user) {
        log("start debugging");
        System.out.println("update a User");
        System.out.println(user.toString());
    }

    @Override
    public void log(String msg) {
        System.out.println("[debug] In UserServiceImpl: " + msg);
    }
}
