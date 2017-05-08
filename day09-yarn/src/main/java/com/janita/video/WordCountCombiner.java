package com.janita.video;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by Janita on 2017-05-08 23:05
 */
public class WordCountCombiner extends Reducer<Text,IntWritable,Text,IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int count = 0 ;
        for (IntWritable value : values){
            count += value.get();
        }
        context.write(key,new IntWritable(count));
    }
}
