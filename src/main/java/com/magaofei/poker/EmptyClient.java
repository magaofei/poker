package com.magaofei.poker;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class EmptyClient extends WebSocketClient {

    public EmptyClient(URI serverUri, Draft draft) {
        super(serverUri, draft);
    }

    public EmptyClient(URI serverURI) {
        super(serverURI);
    }


    @Override
    public void onOpen(ServerHandshake serverHandshake) {

        send("Hello, it is me. Mario :)");
        System.out.println("new connection opened");
    }

    @Override
    public void onMessage(String s) {
        System.out.println("received message: " + s);
    }

    @Override
    public void onError(Exception e) {
        System.err.println("an error occurred:" + e);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("closed with exit code " + i + " additional info: " + s);
    }
}
