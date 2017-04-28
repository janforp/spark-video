package com.janita.video;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by Janita on 2017-04-27 19:26
 * zookeeper客户的API
 */
public class SimpleZkClient {

    private ZooKeeper zkClient = null ;

    @Before
    public void init() throws IOException {
        /**
         * 拿到客户端
         */
        zkClient = new ZooKeeper(ZkConsts.CONNECT_STRING, ZkConsts.SESSION_TIMEOUT, new Watcher() {

            /**
             * 收到事件通知后的回调函数(应该是我们自己的事件处理逻辑)
             * 因为监听器只有一次生效
             * 所以调用完之后再次启动监听器
             * @param watchedEvent
             */
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println
                        ("******* " + watchedEvent.getType() + " ---- " + watchedEvent.getPath());
                try {
                    /**
                     * 所以调用完之后再次启动监听器
                     * 一直监听
                     */
                    zkClient.getChildren("/",true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 数据的CRUD
     * 参数1：路径
     * 参数2：数据
     * 参数3：节点权限
     * 参数4：节点类型
     */
    @Test
    public void createNode() throws KeeperException, InterruptedException {
        String nodeCreated =
                zkClient.create("/servers","helloZk".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("******* " + nodeCreated);
    }

    /**
     * 获取子节点 相当于命令: ls
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void getChildren() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/",true);
        System.out.println("******* " + children);
    }

    /**
     * 创建节点是否存在
     */
    @Test
    public void nodeExist() throws KeeperException, InterruptedException {
        Stat stat = zkClient.exists("/eclipse",true);
        System.out.println("******* " + stat);
    }

    /**
     * 获取zNode的数据
     */
    @Test
    public void getData() throws KeeperException, InterruptedException {
        byte[] data = zkClient.getData("/eclipse",true,null);
        System.out.println("******* " + new String(data));
    }

    /**
     * 删除数据
     * 参数2：指定要删除的版本，-1表示要删除全部版本
     */
    @Test
    public void deleteZNode() throws KeeperException, InterruptedException {
        zkClient.delete("/eclipse",-1);
    }

    /**
     * 修改数据
     */
    @Test
    public void setData() throws KeeperException, InterruptedException {
        zkClient.setData("/eclipse","newData".getBytes(),-1);
    }

}
