package com.hand.spring.proxy.static_.service;

import com.hand.spring.proxy.entity.User;

public class UserServiceProxy implements UserService{

    private UserServiceImpl userServiceImpl;

    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public void add(User user) {
        log("start debugging");
        userServiceImpl.add(user);
    }

    @Override
    public void delete(User user) {
        log("start debugging");
        userServiceImpl.delete(user);
    }

    @Override
    public void update(User user) {
        log("start debugging");
        userServiceImpl.update(user);
    }

    @Override
    public void log(String msg) {
        System.out.println("[debug] In Proxy: " + msg);
    }
}
