package com.janita.video

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Janita on 2017-05-14 09:35
  */
object LocalSpark {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("Janita")
    val sc = new SparkContext(conf)

    sc.textFile("file:///e:\\track-log - 副本.txt")



  }

}
