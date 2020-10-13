package com.infiniture.thrift.server.server;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.infiniture.thrift.api.proto.RPCDateService;
import com.infiniture.thrift.server.service.RPCDateServiceImpl;

@Component
public class RPCThriftServer {
    private static final Logger logger = LoggerFactory.getLogger(RPCThriftServer.class);

    @Value("${thrift.port}")
    private int port;

    @Value("${thrift.minWorkerThreads}")
    private int minThreads;

    @Value("${thrift.maxWorkerThreads}")
    private int maxThreads;

    @Autowired
    private RPCDateServiceImpl rpcDateService;

    private TBinaryProtocol.Factory protocolFactory;
    private TTransportFactory transportFactory;

    public void init() {
        protocolFactory = new TBinaryProtocol.Factory();
        transportFactory = new TTransportFactory();
    }

    public void start() {
        RPCDateService.Processor processor = new RPCDateService.Processor<RPCDateService.Iface>(rpcDateService);
        init();
        try {
            TServerTransport transport = new TServerSocket(port);
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
            tArgs.processor(processor);
            tArgs.protocolFactory(protocolFactory);
            tArgs.transportFactory(transportFactory);
            tArgs.minWorkerThreads(minThreads);
            tArgs.maxWorkerThreads(maxThreads);
            TServer server = new TThreadPoolServer(tArgs);
            logger.info("thrift服务启动成功，端口={}", port);
            server.serve();
        } catch (Exception e) {
            logger.error("thrift服务启动失败", e);
        }
    }
}
