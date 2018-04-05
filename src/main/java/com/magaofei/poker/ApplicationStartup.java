package com.magaofei.poker;

import org.java_websocket.server.WebSocketServer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationEvent> {

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        String host = "127.0.0.1";
        int port = 8887;

        WebSocketServer server = new SimpleServer(new InetSocketAddress(host, port));
        server.run();

        return;
    }

}
