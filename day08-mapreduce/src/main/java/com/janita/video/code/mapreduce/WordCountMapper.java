package com.janita.video.code.mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by Janita on 2017-05-07 13:09
 */
public class WordCountMapper extends Mapper<LongWritable,Text,Text,IntWritable> {

    /**
     * map阶段业务逻辑
     * @param key   某一行的偏移量
     * @param value 一次只传一行数据
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        String[] words = line.split(Consts.SPACE);
        for (String word : words){
            //将单词输出为1
            context.write(new Text(word), new IntWritable(1));
        }
    }
}
