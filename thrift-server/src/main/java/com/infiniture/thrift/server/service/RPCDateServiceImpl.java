package com.infiniture.thrift.server.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.infiniture.thrift.api.proto.RPCDateService;

@Service
public class RPCDateServiceImpl implements RPCDateService.Iface {

    @Override
    public String getDate(String userName) throws TException {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("今天是" + "yyyy年MM月dd日 E kk点mm分");
        String nowTime = simpleDateFormat.format(now);
        return "Hello " + userName + "\n" + nowTime;
    }
}
