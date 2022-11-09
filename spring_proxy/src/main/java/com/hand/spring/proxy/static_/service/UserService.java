package com.hand.spring.proxy.static_.service;

import com.hand.spring.proxy.entity.User;

public interface UserService {
    void add(User user);

    void delete(User user);

    void update(User user);

    void log(String msg);
}
