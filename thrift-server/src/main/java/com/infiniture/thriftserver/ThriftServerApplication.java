package com.infiniture.thriftserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.infiniture.thriftserver.server.RPCThriftServer;

@SpringBootApplication
public class ThriftServerApplication {

	private static RPCThriftServer rpcThriftServer;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ThriftServerApplication.class, args);
		try {
			rpcThriftServer = context.getBean(RPCThriftServer.class);
			rpcThriftServer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
