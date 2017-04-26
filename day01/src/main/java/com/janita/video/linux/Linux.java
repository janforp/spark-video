package com.janita.video.linux;

/**
 * Created by Janita on 2017-04-26 18:48
 * 关于linux
 */
public class Linux {

    /**
     * 一：文件系统
     *
     * bin:普通功能程序
     * sbin:系统管理程序
     * boot:
     * dev:硬件相关
     * etc:配置
     * home文件夹：放不同用户的信息，该系统有几个用户就会有几个用户信息文件夹
     * lib文件夹：公用库
     * lib64：公用库，正因为这样，在安装一些软件的时候才有依赖缺失的情况
     * media:外置的媒体，如U盘，光盘等,挂载到此处
     * usr:unix share resource，共享资源
     * tmp:临时目录，存临时数据
     */

    /**
     * 二：连网络
     * 1.局域网：路由器/交换机，在物理上联机
     *      a.网卡
     *      b.网线
     *      c.操作系统(centos.6.7)配置TCP协议/IP/NETMASK/GATEWAY/DNS
     *      d.IP如何配置，由网关(路由器/交换机)决定(192.168.33.1)
     *      e.则此网关下面的IP范围：192.168.33.2 - 192.168.33.255,但是255是广播地址，所以255不能使用
     *      f.NETMASK:子网掩码，用于看自己属于哪个网段的(255.255.255.0),NETMASK与IP与一下就是网段
     *      f.IP的2进制 & 子网掩码二进制 = 网段地址
     *      g.GATEWAY网关：即路由器地址(谷歌：8.8.8.8,)
     *      h.DNS:域名解析服务器 www.baidu.com 115.98.79.22，浏览器-------->本机的hosts文件/DNS-------->服务器IP
     *      i.如果本地hosts中没有该域名，则向外部的DNS查询
     *      j.在每台机器上配置主机名，方便通过主机名互相访问
     *
     *      ****网关就是路由器的地址
     *
     * 2.VMWARE会产生虚拟的路由器
     */

    /**
     * 三：文件夹操作
     * 1.mkdir -p aaa/bbb/t.txt 在当前目录下面：父目录不存在也能新建
     * 2.mkdir /aaa/bbb/t.txt 在根目录下
     * 3.rmdir aaa,会报错，因为aaa目录下面有内容
     * 4.rm 只能删除文件
     * 5.rm -r aaa:递归删除，就可以把aaa整个文件夹及下面的所有的内容删除
     * 6.rm -rf aaa:强制删除(不带提示)
     * 7.mv nameA nameB：修改文件夹名称
     */

    /**
     * 四：文件操作
     * 1.touch somefile.1 :创建一个空文件
     * 2.echo "some text" > somefile.2 把这段文本输出到文件，若文件不存在则创建
     * 3.cat somefile.1 查看某个文件
     * 4.ls > somefile.2 :可以把ls要显示的内容写到somefile.2文件中
     * 5.>:重定向
     * 6.echo "some text" >> somefile.2 :向某个文件中追加一些内容，若是>则覆盖
     * 7.用文本编辑器来编辑生成文件 vi somefile.3 :直接打开该文件
     *
     *
     *
     */
}
