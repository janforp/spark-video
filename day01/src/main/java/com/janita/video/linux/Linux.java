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
     * 8.mv 移动(也可重命名)
     * 9.rm 删除
     */

    /**
     * 五：VI文本编辑快捷键(在一般模式下使用)
     * a    在光标后一位开始插入
     * A    在该行的最后插入
     * I    在该行的最前面插入
     * gg   直接跳到文件的首航
     * G    直接跳到文件的末行
     * dd   直接删除一行，若 5dd ,在一次性删除光标后面的5行
     * yy   复制当前行 若3yy,在复制3行
     * p    粘贴
     * v    进入字符选择模式，选择完成后按y复制，按p粘贴
     * ctrl+v   进入块选择模式
     * shift+v  行选择模式.
     * q!   强制退出
     * 统一替换：%s/oldWord/newWord:在地行命令模式中输入,效果：  查找文件中所有的oldWord替换成newWord
     * 查找：  /keyword    效果：查找文件中出现的keyword,并定位到第一个出现的地方，按n下一个，按N定位到上一个
     */

    /**
     * 六：文件权限操作
     * drwxr-xr-x
     * d:   标识节点类型(d:文件夹 -：文件 1：连接)
     * r：可读(显示内容) w：可写(修改)    x：可执行(运行)
     * 第一组rwx： 表示拥有者对他的权限
     * 第二组r-x:  表示所属组的权限
     * 第三组r-x:  表示其他用户的权限
     *
     * 1.修改权限   chmod g -rw somefile    不让组用户的rw权限
     * 2.chmod o -rw somefile   不让其他人有rw权限
     * 3.chmod u +x somefile    所有者加上x权限
     * 4.chmod 777 somefile 所有人有所有权限
     * 5.文件夹权限 的时候里面的权限不会自动改，若要一起改则递归改 chmod -R 770 dir 递归修改文件夹权限
     * 6.更改所有者  chown username:group -R somefile
     */

    /**
     * 七：基本的用户管理
     * 1.添加用户(root)   useradd username    添加username用户
     * 2.为用户添加密码    passwd username 为username用户添加密码
     * 3.用户登录之后输入pwd会在/home/username目录里面
     * 4.一般情况下不用root登录,输入su ，要求输入密码:    输入root密码操作
     * 5.sudo usseradd huangxiaoming 临时获得root的权限添加用户，要求输入密码
     * 6.为用户配置sudo权限：vi /etc/sudoers 添加一行：username ALL=(ALL)  ALL
     */

    /**
     * 八
     * 1.修改主机名：vi /etc/sysconfig/network    加上主机名
     * 2.修改IP:vi /etc/sysconfig/network-srripts/ifcfg-eth0
     * 3.查看系统版本：uname -a
     * 4.系统内核版本 uname-u
     * 5.date -help 查看日期相关的命令
     * 6.mount -t iso9660 -o -ro /dev/cdrom /mnt/cdrom 挂载外部存储设备到系统
     *      a.mkdir /mnt/cdrom  创建目录用于挂载
     *      b.mount -t iso9660 -o -ro /dev/cdrom /mnt/cdrom 将设备/dev/cdrom挂载到 挂载点: /mnt/cdrom中
     *      c.umount    /mnt/cdrom  接触挂载
     *
     *  7.du -sh Packages/  查看Packages目录下面的文件的大小    3.4G Packages
     *  8.du -sh * 查看该目录下的所有文件夹/文件的大小
     *  9.df -h :查看磁盘空间
     */

    /**
     * 关机：halt
     * 重启：reboot
     */

    /**
     * SSH
     * 远程登录的安全外壳协议
     * 有两种身份验证机制
     * 1.用户名+密码验证
     * 2.密钥验证：有了密钥就不用输入密码
     */

    /**
     * 免密登录
     * 1.ssh客户的+ssh服务端
     * 2.ssh ip
     * 3.scp somefile root@ip:/home 在当前几期把somefile拷贝到ip机子的/home文件夹下面
     */

    /**
     * 配置免密登录步骤：
     * 加入 A 要登录 B
     * 在A上操作
     * 1.首先生成秘钥对:   ssh-keygen      (一直回车)   生成了id_rsa及id_rsa.pub
     * 2.再将A自己的公钥拷贝并追加到B的授权列表文件authorized_keys中 ：   ssh-copy-id + B的IP
     * 3.输入目标主机密码
     * 4.A登录到B之后，想退出，输入:    exit
     */

}
