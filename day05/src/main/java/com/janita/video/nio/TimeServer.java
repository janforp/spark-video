package com.janita.video.nio;

/**
 * Created by Janita on 2017-04-29 17:11
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer,"NIO-MultiplexerTimeServer - 001").start();
    }
}
