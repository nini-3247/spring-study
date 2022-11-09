package com.hand.spring.dao.impl;

import com.hand.spring.dao.HelloDao;
import com.hand.spring.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloOracleDaoImpl implements HelloDao {
    Logger logger = LoggerFactory.getLogger(HelloOracleDaoImpl.class);

    private HelloDao helloDao;

    @Override
    public void showImpl() {
        logger.info("Get data from --------------> Oracle");
    }

    public HelloDao getHelloDao() {
        return helloDao;
    }

    public void setHelloDao(HelloDao helloDao) {
        this.helloDao = helloDao;
    }
}
