package com.janita.video;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Janita on 2017-04-28 09:32
 */
public class DistributedClient {

    private static ZooKeeper zk = null ;
    /**
     * volatile:
     */
    private volatile Map<String,String> serverMap;

    static {
        //获取连接
        try {
            zk = ZkUtil.getConnect(ZkConsts.CONNECT_STRING, ZkConsts.SESSION_TIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    try {
                        ZkUtil.getServerList(zk,ZkConsts.PARENT_NODE);
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("******* " + zk);
    }

    private void handle(){
        System.out.println("*******");
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        //获取servers的子节点信息，从中获取服务器信息列表
        DistributedClient client = new DistributedClient();
        client.getServerList();
        client.handle();
    }

    public void getServerList() throws KeeperException, InterruptedException {

        serverMap = ZkUtil.getChildrenData(zk,ZkConsts.PARENT_NODE,ZkUtil.getServerList(zk,ZkConsts.PARENT_NODE));
        System.out.println("------" + serverMap);
    }
}
