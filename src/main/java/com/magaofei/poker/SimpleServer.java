package com.magaofei.poker;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class SimpleServer extends WebSocketServer {

//
//    @EventListener(ApplicationReadyEvent.class)
//    public void open() {
//        String host = "127.0.0.1";
//        int port = 8887;
//
//        WebSocketServer server = new SimpleServer(new InetSocketAddress(host, port));
//        server.run();
//    }
    /**
     * 构造方法
     * @param address 传入一个地址
     */
    public SimpleServer (InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onStart() {
        System.out.println("server started successfully");
    }


    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        webSocket.send("Welcome to the server!");

        //This method sends a message to all clients connected
        broadcast( "new connection: " + clientHandshake.getResourceDescriptor() );

        System.out.println("new connection to " + webSocket.getRemoteSocketAddress());

    }


    @Override
    public void onMessage(WebSocket webSocket, String s) {
        System.out.println("received message from "	+ webSocket.getRemoteSocketAddress() + ": " + s);
    }



    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        System.out.println("closed " + webSocket.getRemoteSocketAddress());
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        System.err.println("an error occured on connection " + webSocket.getRemoteSocketAddress()  + ":" + e);
    }
}
