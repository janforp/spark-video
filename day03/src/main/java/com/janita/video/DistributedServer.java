package com.janita.video;

import org.apache.zookeeper.*;
import java.io.IOException;

/**
 * Created by Janita on 2017-04-27 20:08
 */
public class DistributedServer {

    private ZooKeeper zk = null ;

    /**
     * 获取连接
     * @throws IOException
     */
    private void getConnect() throws IOException {
        zk = new ZooKeeper(ZkConsts.CONNECT_STRING, ZkConsts.SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("*******");
                try {
                    zk.getChildren("/",true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 向zk集群注册服务器信息
     * @param hostname
     * @throws KeeperException
     * @throws InterruptedException
     */
    private void registerServer(String hostname) throws KeeperException, InterruptedException {
        String create = zk.create(ZkConsts.PARENT_NODE+"/server",hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("******* " + hostname + "  is online .. " + create);
    }

    /**
     * 业务功能
     */
    private void handleBusiness(String hostname) throws InterruptedException {
        System.out.println("******* " + hostname + "start working ...");
        Thread.sleep(Long.MAX_VALUE);
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String hostname = "hdp01";
        if (args.length >0){
            hostname = args[0];
        }
        DistributedServer server = new DistributedServer();
        server.getConnect();
        server.registerServer(hostname);
        //启动业务功能
        server.handleBusiness(hostname);
    }
}
