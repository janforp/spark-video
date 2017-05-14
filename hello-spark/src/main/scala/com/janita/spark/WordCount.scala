package com.janita.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Janita on 2017-05-14 11:57
  */
object WordCount {

  def main(args: Array[String]): Unit = {
    //非常重要:通向Spark集群的入口
    val conf = new SparkConf().setAppName("WC").setMaster("local")
    val sc = new SparkContext(conf)
    sc.textFile("e:\\track-log - 副本.txt").flatMap(_ . split(" ")).map((_, 1)).reduceByKey(_ + _).sortBy(_._2, false).saveAsTextFile("e:\\out")
    sc.stop()

  }

}
