package com.janita.video;

/**
 * Created by Janita on 2017-04-28 09:33
 */
public class ZkConsts {

    /**
     * 连接zookeeper的地址
     * 前面的连不上就会连后面的
     */
    public static final String CONNECT_STRING = "192.168.128.101:2181,192.168.128.101:2182,192.168.128.103:2181,192.168.128.104:2181";
    /**
     * 回话延迟时间
     */
    public static final int SESSION_TIMEOUT = 2000;
    public static final String PARENT_NODE = "/servers";

}
