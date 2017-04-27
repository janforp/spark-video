package com.janita.video.note;

/**
 * Created by Janita on 2017-04-27 15:21
 * 字段安装tomcat的脚本
 */
public class ScriptAutoInstallTomcat {

    /**
     *#!/bin/bash

     SERVERS="node-3.itcast.cn node-4.itcast.cn"
     PASSWORD=123456
     BASE_SERVER=172.16.203.100

     auto_ssh_copy_id() {
     expect -c "set timeout -1;
     spawn ssh-copy-id $1;
     expect {
     *(yes/no)* {send -- yes\r;exp_continue;}
     *assword:* {send -- $2\r;exp_continue;}
     eof        {exit 0;}
     }";
     }

     ssh_copy_id_to_all() {
     for SERVER in $SERVERS
     do
     auto_ssh_copy_id $SERVER $PASSWORD
     done
     }

     ssh_copy_id_to_all


     for SERVER in $SERVERS
     do
     scp install.sh root@$SERVER:/root
     ssh root@$SERVER /root/install.sh
     done
     *
     */

    /**
     #!/bin/bash
     BASE_SERVER=172.16.203.100
     yum install -y wget
     wget $BASE_SERVER/soft/jdk-7u45-linux-x64.tar.gz
     tar -zxvf jdk-7u45-linux-x64.tar.gz -C /usr/local
     cat >> /etc/profile << EOF
     export JAVA_HOME=/usr/local/jdk1.7.0_45
     export PATH=\$PATH:\$JAVA_HOME/bin
     EOF
     */
}
