package com.janita.video.note;

/**
 * Created by Janita on 2017-04-27 10:30
 * linux软件安装
 */
public class InstallSoftWareOnLinux {

    /**
     * 一：安装JDK
     * 1.wget   下载/或者上传 (a.ftp工具，b.sftp:可以在虚拟机与本地机器之间传输)
     * 2.压缩解压缩相关命令：
     *      a.gzip  somefile    压缩
     *      b.unzip somefile    解压缩
     *      c.tar -cvf somefile 打包
     *      d.tar -xzvf somefile 解包
     *      e.tar -zcvf somefile    压缩打包
     *   tar -xzvf jdk.tar -C
     *
     *  3.$PATH 查看没有java的路径
     *  4.配置环境变量 vi /etc/profile
     *      a.export JAVA_HOME = 路径
     *      b.export PATH = $PATH;%JAVA_HOME%/bin;
     */

    /**
     * 4.avi
     * 安装mysql
     * rpm -ivh MySQL-server-x.xdd
     * 会少一些库
     * 查看依赖：yum list |grep libao.so.1
     *
     * YUM  :相当于Maven
     * 可以配置本地源
     *
     * find / -name mysql   :在系统上寻找mysql安装在哪里了
     * netstat -nltp 查看网络端口
     *
     * rpm -qa | grep mysql 查看mysql的rpm包
     *
     *
     */
}
