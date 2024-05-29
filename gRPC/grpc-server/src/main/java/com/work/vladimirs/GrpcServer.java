package com.work.vladimirs;

import com.work.vladimirs.service.GrpcService;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

@Service
public class GrpcServer implements AutoCloseable, ApplicationListener<ContextRefreshedEvent> {

    private static Logger LOGGER = Logger.getLogger(GrpcServer.class.getName());
    private io.grpc.Server server;
    private final int port;
    private GrpcService service;

    public GrpcServer(@Value("${grpc.port}") int port,
                      GrpcService service) {
        this.port = port;
        this.service = service;
    }

    @Override
    public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {
        LOGGER.info("onApplicationEvent");
        try {
            server = ServerBuilder.forPort(port)
                    .addService(service)
                    .build()
                    .start();
        } catch (Throwable t) {
            LOGGER.fine("An Exception on starting server");
        }
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Server close");
        if (server != null) {
            try {
                server.shutdown();
            } catch (Throwable t) {
                LOGGER.fine("An Exception on stopping server");
            }
        }
    }
}
