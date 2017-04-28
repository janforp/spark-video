package com.janita.video.distribute;

import com.janita.video.zookeeper.ZkConsts;
import com.janita.video.zookeeper.ZkUtil;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by Janita on 2017-04-28 10:21
 * 分布式系统的服务器
 */
public class DistributeServer {

    private static ZooKeeper zk;

    public static void main(String[] args) throws IOException {
        //获取zookeeper连接
        zk = ZkUtil.getConnect(ZkConsts.CONNECT_STRING, ZkConsts.SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });
        //利用连接注册服务器信息

        //业务逻辑

    }
}
