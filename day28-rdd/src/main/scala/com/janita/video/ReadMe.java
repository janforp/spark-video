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


    /**
     * Internally, each RDD is characterized by five main properties:
     *
     *  - A list of partitions      多个分区
     *  - A function for computing each split   每个分区有一个函数计算
     *  - A list of dependencies on other RDDs  依赖一系列的其他的RDD
     *  - Optionally, a Partitioner for key-value RDDs (e.g. to say that the RDD is hash-partitioned)
     *  - Optionally, a list of preferred locations to compute each split on (e.g. block locations for
     *    an HDFS file)
     *
     *
     *
     *    一个分区就在一台机器上,但是一台机器上可能有多个分区
     *
     */
}