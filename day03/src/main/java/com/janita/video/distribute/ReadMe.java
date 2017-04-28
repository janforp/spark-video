package com.janita.video.distribute;

/**
 * Created by Janita on 2017-04-28 10:12
 */
public class ReadMe {

    /**
     * 分布式应用系统服务器上下线动态感知程序开发
     *
     * 注意：业务功能应该与此功能解耦
     */

    /**
     * 1.服务端启动时去注册信息
     * 2.客户端启动时先去看哪些服务器在线
     *      a.启动就是getChildren,获取当前服务器列表,并且注册监听(当服务器下线时感知)
     *      b.当有服务器下线时重新获取列表，并注册监听
     */
}