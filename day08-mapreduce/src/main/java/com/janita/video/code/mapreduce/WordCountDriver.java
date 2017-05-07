package com.janita.video.code.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Created by Janita on 2017-05-07 13:30
 * 相当yarn集群的客户端
 * 需要在此封装相关运行参数,指定jar包
 */
public class WordCountDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();
        conf.set(Consts.MAP_REDUCE_FRAMEWORK_NAME,"yarn");
        conf.set(Consts.YARN_RESOURCEMANAGER_HOSTNAME,"hdp01");
        Job job = Job.getInstance(conf);

        //指定jar包
        job.setJarByClass(WordCountDriver.class);

        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //需要统计的文件
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        //输出结果
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        //将job中配置的参数,以及job中使用的jar包,提交给yarn运行
//        job.submit();
        boolean res = job.waitForCompletion(true);
        System.exit(res?0:1);
    }
}
