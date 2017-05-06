package com.janita.video.code;

import com.janita.video.code.util.HDFSUtils;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Janita on 2017-05-06 21:13
 */
public class HDFSTest {

    public static void main(String[] args) throws Exception {
//        RemoteIterator<LocatedFileStatus> list = HDFSUtils.lsDir(null,new Path("/janita"),true);
//
//        while (list.hasNext()){
//            LocatedFileStatus fileStatus = list.next();
//            System.out.println(fileStatus.getBlockSize());
//            System.out.println(fileStatus.getOwner());
//            System.out.println(fileStatus.getReplication());
//            System.out.println(fileStatus.getPermission());
//            System.out.println(fileStatus.getPath().getName());
//            System.out.println("*********");
//
//        }


//        FileStatus[] fileStatuses = HDFSUtils.listDir(null,new Path("/"));
//        for (FileStatus status :fileStatuses){
//            System.out.println(status.getPath().getName());
//        }

//        HDFSUtils.upload(null,new File("C:\\Users\\Administrator\\Desktop\\dataFormat.json"),new Path("/janita/up.txt"));

    }

    @Test
    public void test2() throws InterruptedException, IOException, URISyntaxException {
        HDFSUtils.randomAccess(null,new Path("/janita/up.txt"),new File("C:\\Users\\Administrator\\Desktop\\data2Format.json"),100L);
    }

    @Test
    public void print() throws InterruptedException, IOException, URISyntaxException {
        HDFSUtils.print(null,new Path("/janita/up.txt"));
    }
}
