package com.janita.video.distribute;

import com.janita.video.zookeeper.ZkConsts;
import com.janita.video.zookeeper.ZkUtil;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janita on 2017-04-28 10:29
 */
public class DistributeClient {

    /**
     * 主节点
     */
    private static String GROUP_NODE = "sgroup";
    private static ZooKeeper zk;
    private static Stat stat = new Stat();
    private volatile static List<String> serverList;

    static {
        try {
            zk = ZkUtil.getConnect(ZkConsts.CONNECT_STRING, ZkConsts.SESSION_TIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getType() == Event.EventType.NodeChildrenChanged
                            && ("/" + GROUP_NODE).equals(event.getPath())){
                        try {
                            updateServerList();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateServerList() throws KeeperException, InterruptedException, UnsupportedEncodingException {
        List<String> newServerList = new ArrayList<>();
        List<String> subList = zk.getChildren("/"+GROUP_NODE,true);
        for (String node : subList){
            byte[] data = zk.getData("/" +GROUP_NODE + "/" +node ,false,stat);
            newServerList.add(new String(data,"UTF-8"));
        }
        serverList = newServerList;
    }

    public static void main(String[] args){
        DistributeClient client = new DistributeClient();

    }
}
