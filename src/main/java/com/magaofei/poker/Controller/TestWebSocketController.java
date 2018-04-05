package com.magaofei.poker.Controller;

import com.magaofei.poker.EmptyClient;
import com.magaofei.poker.SimpleServer;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.server.WebSocketServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetSocketAddress;
import java.net.URI;


@RestController
@RequestMapping(path = "testWebSocket")
public class TestWebSocketController {

    @RequestMapping(method = RequestMethod.POST)
    public void testWebSocket() {

        String host = "0.0.0.0";
        int port = 8887;

        WebSocketServer server = new SimpleServer(new InetSocketAddress(host, port));
        server.run();

    }


    @RequestMapping(method = RequestMethod.GET)
    public void testConnectWebSocket() {

        try {

            String host = "ws://127.0.0.1:8887";

            WebSocketClient client = new EmptyClient(new URI(host));
            client.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


}
