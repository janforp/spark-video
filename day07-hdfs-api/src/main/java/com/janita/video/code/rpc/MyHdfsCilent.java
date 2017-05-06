package com.janita.video.code.rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by Janita on 2017-05-06 22:28
 */
public class MyHdfsCilent {

    public static void main(String[] args) throws IOException {

        ClientNameNodeProtocol nameNode = RPC.getProxy(ClientNameNodeProtocol.class,ClientNameNodeProtocol.versionID,new InetSocketAddress("localhost",8888),new Configuration());

        String res = nameNode.getMetaData("/test");
        System.out.println(res);
    }
}
