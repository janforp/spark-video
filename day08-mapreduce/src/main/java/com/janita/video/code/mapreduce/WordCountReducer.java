package com.janita.video.code.mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by Janita on 2017-05-07 13:10
 */
public class WordCountReducer extends Reducer<Text,IntWritable,Text,IntWritable> {

    /**
     * reduce业务逻辑
     * @param key       单词,如 ban
     * @param values    单词次数    1,2,3,4...
     */
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        int count = 0 ;
        for (IntWritable value : values){
            count += value.get();
        }
        context.write(key,new IntWritable(count));
    }
}
