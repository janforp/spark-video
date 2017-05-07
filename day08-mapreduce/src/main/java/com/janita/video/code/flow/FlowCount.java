package com.janita.video.code.flow;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.ObjectWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Created by Janita on 2017-05-07 18:29
 */
public class FlowCount {

    static class FlowCountMapper extends Mapper<LongWritable,Text,Text,FlowBean>{

    }


    public static void main(String[] args) {

    }


}
