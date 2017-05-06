package com.janita.video.code.rpc.webrpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by Janita on 2017-05-06 22:41
 */
public class UserLoginAction {

    public static void main(String[] args) throws IOException {
        IUserLoginService service = RPC.getProxy(IUserLoginService.class,100L,new InetSocketAddress("localhost",9999),new Configuration());
        String rest = service.login("Janita","123");
        System.out.println(rest);
    }
}
