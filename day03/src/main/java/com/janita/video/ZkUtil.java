package com.janita.video;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Janita on 2017-04-28 09:36
 */
public class ZkUtil {

    /**
     * 获取连接
     * @throws IOException
     */
    public static ZooKeeper getConnect(String connectString, int sessionTimeout, Watcher watcher) throws IOException {
        return new ZooKeeper(connectString, sessionTimeout, watcher);
    }

    /**
     * 获取所有字节点
     * @param zk
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static List<String> getServerList(ZooKeeper zk,String parentNodePath) throws KeeperException, InterruptedException {
        return zk.getChildren(parentNodePath,true);
    }

    /**
     * 获取子节点下面的数据
     * @param zk
     * @param parentNodePath
     * @param childrenPath
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static Map<String,String> getChildrenData(ZooKeeper zk, String parentNodePath, List<String > childrenPath) throws KeeperException, InterruptedException {
        Map<String ,String > map = new HashMap<>();
        for (String child :childrenPath){
            byte[] data = zk.getData(parentNodePath + "/" +child , false ,null);
            map.put(parentNodePath + "/" +child,new String(data));
        }
        return map;
    }
}
