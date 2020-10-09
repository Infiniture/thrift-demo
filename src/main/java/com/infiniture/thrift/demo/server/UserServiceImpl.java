package com.infiniture.thrift.demo.server;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infiniture.thrift.demo.user.UserService;

public class UserServiceImpl implements UserService.Iface {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final String INFINITURE = "infiniture";

    @Override
    public String getName(int id) throws TException {
        logger.info("received getName, id = {}:", id);
        return INFINITURE;
    }

    @Override
    public boolean isExist(String name) throws TException {
        logger.info("receive is Exist, name = {}", name);
        return INFINITURE.equals(name);
    }
}
