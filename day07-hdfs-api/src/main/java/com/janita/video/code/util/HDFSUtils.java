package com.janita.video.code.util;

import com.janita.video.code.constant.Consts;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.hdfs.server.namenode.FSNamesystem;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by Janita on 2017-05-04 22:46
 * hdfs工具
 */
public class HDFSUtils {

    private static FileSystem initFileSystem(FileSystem fileSystem) throws URISyntaxException, IOException, InterruptedException {

        if (fileSystem == null){
            Configuration configuration = new Configuration();
            configuration.set("fs.defaultFS", Consts.HDFS_HOST);
            configuration.set("dfs.replication","3");
            fileSystem = FileSystem.get(new URI(Consts.HDFS_HOST),configuration,Consts.ROOT);
        }
        return fileSystem;
    }

    /**
     * 上传文件到hdfs
     * @param fileSystem    hdfs服务器
     * @param source        原文件
     * @param to            目标文件地址
     */
    public static void addFile(FileSystem fileSystem, Path source, Path to) throws Exception {
        fileSystem = initFileSystem(fileSystem);
        fileSystem.copyFromLocalFile(source,to);
    }

    /**
     * 从hdfs上下载文件
     * @param fileSystem    hdfs服务器
     * @param hdfsSource    hdfs上的文件
     * @param to            下载到的地址
     * @throws IOException
     */
    public static void download(FileSystem fileSystem ,Path hdfsSource ,Path to) throws Exception {
        fileSystem = initFileSystem(fileSystem);
        fileSystem.copyToLocalFile(hdfsSource,to);
        fileSystem.close();
    }

    /**
     * 新建文件夹
     * @param fileSystem
     * @param newPath
     * @throws IOException
     */
    public static void mkdir(FileSystem fileSystem,Path newPath) throws Exception {
        fileSystem = initFileSystem(fileSystem);
        fileSystem.mkdirs(newPath);
    }

    /**
     * 删除文件
     * @param fileSystem
     * @param path
     * @throws IOException
     */
    public static void delete(FileSystem fileSystem,Path path,boolean recurise) throws Exception {
        fileSystem = initFileSystem(fileSystem);
        fileSystem.delete(path,recurise);
    }

    /**
     * 修改文件名字
     * @param fileSystem
     * @param oldName
     * @param newName
     * @throws IOException
     */
    public static void rename(FileSystem fileSystem,Path oldName , Path newName) throws Exception {
        fileSystem = initFileSystem(fileSystem);
        fileSystem.rename(oldName,newName);
    }

    /**
     * 递归查询目录下的所有文件
     * @param fileSystem
     * @param path  目录
     * @param isR   是否递归查询
     * @return
     * @throws IOException
     */
    public static RemoteIterator<LocatedFileStatus> LSDir(FileSystem fileSystem,Path path,boolean isR) throws IOException, URISyntaxException, InterruptedException {
        fileSystem = initFileSystem(fileSystem);
        return fileSystem.listFiles(path,isR);
    }

}
