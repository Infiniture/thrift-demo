package com.infiniture.thrift.demo.server;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infiniture.thrift.demo.proto.user.UserService;

public class Server {

    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    private void startServer() {
        UserService.Processor processor = new UserService.Processor<UserService.Iface>(new UserServiceImpl());

        try {
            TServerTransport transport = new TServerSocket(2345);
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
            tArgs.processor(processor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            tArgs.transportFactory(new TTransportFactory());
            tArgs.minWorkerThreads(10);
            tArgs.maxWorkerThreads(20);
            TServer server = new TThreadPoolServer(tArgs);
            server.serve();
        } catch (Exception e) {
            logger.error("thrift服务启动失败", e);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
    }
}
