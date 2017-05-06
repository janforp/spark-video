package com.janita.video.code.rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

/**
 * Created by Janita on 2017-05-06 22:23
 */
public class PublishServerUtil {

    public static void main(String[] args) throws IOException {
        RPC.Builder builder = new RPC.Builder(new Configuration());
        builder.setBindAddress("localhost").setPort(8888).setProtocol(ClientNameNodeProtocol.class).setInstance(new MyNameNode());

        RPC.Server server = builder.build();

        server.start();
    }
}
