package com.janita.video.code.flow;

import com.janita.video.code.mapreduce.Consts;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Created by Janita on 2017-05-07 18:29
 * 对手机用户上行流量,下行流量及总流量的统计
 */
public class FlowCount {

    private static class FlowCountMapper extends Mapper<LongWritable,Text,Text,FlowBean>{

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            String[] fields = line.split(Consts.ENTER);
            String phoneNum = fields[1];
            Long upFlow = Long.parseLong(fields[fields.length - 3]);
            Long dFlow = Long.parseLong(fields[fields.length - 2]);

            context.write(new Text(phoneNum),new FlowBean(upFlow,dFlow));

        }
    }

    private static class FlowCountReducer extends Reducer<Text,FlowBean,Text,FlowBean>{

        @Override
        protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
            Long sumUpFlow = 0L;
            Long sumDFlow = 0L ;

            for (FlowBean bean :values){
                sumUpFlow += bean.getUpFlow();
                sumDFlow += bean.getdFlow();
            }

            FlowBean bean = new FlowBean(sumUpFlow,sumDFlow);
            context.write(key,bean);
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //指定jar包
        job.setJarByClass(FlowCount.class);

        job.setMapperClass(FlowCountMapper.class);
        job.setReducerClass(FlowCountReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        //数据分区
        job.setPartitionerClass(ProvincePartitioner.class);
        job.setNumReduceTasks(5);

        //需要统计的文件
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        //输出结果
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        boolean res = job.waitForCompletion(true);
        System.exit(res?0:1);
    }
}
