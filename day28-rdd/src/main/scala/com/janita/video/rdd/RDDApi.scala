package com.janita.video.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Janita on 2017-05-12 10:35
  */
object RDDApi {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("janita").setMaster("local")

    val sc = new SparkContext(conf)

    val rdd1 = sc.parallelize(Array(1,2,3,4))

    val len = rdd1.partitions.length

    println(len)



  }

}
