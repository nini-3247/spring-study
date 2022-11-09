package com.hand.spring.service.impl;

import com.hand.spring.dao.HelloDao;
import com.hand.spring.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Autowired
    @Lazy
    private HelloService helloService;

    private HelloDao helloDao;

    @Override
    public void showImpl() {
        System.out.println("service implement...");
    }

    public HelloDao getHelloDao() {
        return helloDao;
    }

    public void setHelloDao(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

    public HelloService getHelloService() {
        return helloService;
    }
}
