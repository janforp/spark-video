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

    /**
     * 5.avi 防火墙
     * 1.service iptables status
     * 详见课件01_iptables教程
     */

    /**
     * 6.avi
     *
     * 1.pstree
     * 2.shell中的变量
     * 3.系统变量$HOME :获取用户的主目录， $PWD :当前目录 $USER :当前用户.....
     * 4.显示当前shell中所有变量 : set
     * 5.定义变量时=两边不要空格
     * 6.撤销变量 unset + 变量名，但是readonly B=2此变量撤销不掉
     * 7.export 变量 可以把变量提升为全局环境变量
     * 8.用飘号"`"可以引用上一个命令的结果 A=$(ls-la) 或者 A=`ls-la`
     */

    /**
     * 7.avi
     *  shell 编程
     *  1.$?    表示上一个命令退出的状态
     *  2.$$
     */

    /**
     * 8.avi，9.avi
     *
     * 1.sed命令  删除  sed '2d' example    删除example文件的第二行 ， sed '/test/'d example 删除example中有test的行
     * 2.awk命令
     * 3.cut命令  可以从一个文本文件中提取文本列 echo $PATH | cut -d ':' -f 3,5
     * 4.sort命令 对行排序
     * 5.wc命令
     *
     * 使用时资料手册去查即可
     *
     */


    /**
     * last -n 5    可以查看最近登录的5个记录
     */
}
