package com.janita.video.code;

import com.janita.video.code.util.HDFSUtils;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

/**
 * Created by Janita on 2017-05-06 21:13
 */
public class HDFSTest {

    public static void main(String[] args) throws Exception {
        RemoteIterator<LocatedFileStatus> list = HDFSUtils.LSDir(null,new Path("/janita"),true);

        while (list.hasNext()){
            LocatedFileStatus fileStatus = list.next();
            System.out.println(fileStatus.getBlockSize());
            System.out.println(fileStatus.getOwner());
            System.out.println(fileStatus.getReplication());
            System.out.println(fileStatus.getPermission());
            System.out.println(fileStatus.getPath().getName());
            System.out.println("*********");

        }
    }
}
