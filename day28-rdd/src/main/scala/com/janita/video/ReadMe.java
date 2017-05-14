package com.janita.video;

/**
 * Created by Janita on 2017-05-14 08:55
 */
public class ReadMe {
    /**
     *  1.学习到03.spark简介
     *
     * sc.textFile("hdfs://.....).flatMap(_.split(" ")).map(_, 1).reduceByKey(_ + _ , 1).sortBy(_._2, false).collect
     *
     *
     *
     */
}