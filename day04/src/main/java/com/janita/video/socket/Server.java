package com.janita.video.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Janita on 2017-04-28 15:42
 */
public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress("localhost",8899));

        //接受客户端的连接请求,一直阻塞到有连接才返回
        while (true){
            Socket socket = server.accept();
            //启动新线程做业务
           new Thread(new ServerTask(socket)).start();
        }
    }
}
