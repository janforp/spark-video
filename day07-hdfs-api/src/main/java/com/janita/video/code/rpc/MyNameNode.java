package com.janita.video.code.rpc;

/**
 * Created by Janita on 2017-05-06 22:21
 */
public class MyNameNode implements ClientNameNodeProtocol{

    /**
     * 模拟namenode方法之一:查询元数据
     * @param path
     * @return
     */
    @Override
    public String getMetaData(String path){
        return path + " : -{BLK_1,BLK_2} ....";
    }
}
