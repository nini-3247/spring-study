package com.hand.spring.dao.impl;

import com.hand.spring.dao.HelloDao;
import com.hand.spring.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloMySqlDaoImpl implements HelloDao {
    Logger logger = LoggerFactory.getLogger(HelloMySqlDaoImpl.class);

    private HelloDao helloDao;

    @Override
    public void showImpl() {
        logger.info("Get data from --------------> MySql");
    }
}
