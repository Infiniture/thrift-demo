package com.infiniture.thrift.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.infiniture.thrift.demo.server.RPCThriftServer;

@SpringBootApplication
public class ThriftDemoApplication {

    private static RPCThriftServer rpcThriftServer;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ThriftDemoApplication.class, args);
        try {
            rpcThriftServer = context.getBean(RPCThriftServer.class);
            rpcThriftServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
