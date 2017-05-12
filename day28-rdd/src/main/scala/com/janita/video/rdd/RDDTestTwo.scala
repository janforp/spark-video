package com.janita.video.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Janita on 2017-05-12 11:24
  */
object RDDTestTwo {

  /**
    * 初始化SparkContext
 *
    * @return SparkContext
    */
  def init() : SparkContext = {
    val conf = new SparkConf().setAppName("rddtest").setMaster("local")
    val sc = new SparkContext(conf)
    sc
  }

  def main(args: Array[String]): Unit = {

    val sc = init()
//    flatMapRdd(sc)
//    filterRdd(sc)
//    joinRdd(sc)
//    unionRdd(sc)
//    groupByKey(sc)
//    coGroup(sc)
//    reduce(sc)
//    reduceByKey(sc)
    sortByKeyDescAsc(sc)
  }

  /**
    * 将rdd1里面的每一个元素先切分在压平
    * @param sc
    */
  def flatMapRdd(sc : SparkContext) : Unit = {

    val rdd = sc.parallelize(Array("a b c","d e f","h i j"))

    val rdd2 = rdd.flatMap(_.split(' '))

    rdd2.foreach(x => println(x))
  }

  /**
    * 对rdd进行过滤
    * @param sc
    */
  def filterRdd(sc : SparkContext) : Unit = {

    val rddArr = sc.parallelize(List(5,6,7,3,8,2,9,1,4,10))

    val rddArr2 = rddArr.map(_*2).sortBy(x=>x, true)

    val rddFilter = rddArr2.filter(_ >= 10)

    rddFilter.foreach(x => println(x))
  }

  /**
    * 对RDD进行join
    * @param sc
    * @return
    */
  def joinRdd(sc : SparkContext) : Unit = {

    val rddOne = sc.parallelize(List(("tom",1),("jerry",3),("kitty",2)))
    val rddTwo = sc.parallelize(List(("jerry",2),("tom",1),("shuke",2)))

    val rdd = rddOne.join(rddTwo)

    rdd.foreach(x => println(x))
  }

  /**
    * 对RDD求union
    * @param sc
    */
  def unionRdd(sc : SparkContext) :Unit = {

    val rddOne = sc.parallelize(List(("tom",1),("jerry",3),("kitty",2)))
    val rddTwo = sc.parallelize(List(("jerry",2),("tom",1),("shuke",2)))

    val rdd = rddOne union rddTwo

    rdd.foreach(x => println(x))
  }

  /**
    * 按key分组
    * @param sc
    */
  def groupByKey(sc : SparkContext) : Unit = {

    val rdd1 = sc.parallelize(List(("tom", 1), ("jerry", 3), ("kitty", 2)))
    val rdd2 = sc.parallelize(List(("jerry", 2), ("tom", 1), ("shuke", 2)))

    val rdd4 = rdd1 union rdd2

    val rdd = rdd4.groupByKey

    rdd.foreach(x => println(x))

  }

  /**
    * 注意cogroup与groupByKey的区别
    * @param sc
    *
    */
  def coGroup(sc : SparkContext) : Unit = {

    val rdd1 = sc.parallelize(List(("tom", 1), ("tom", 2), ("jerry", 3), ("kitty", 2)))
    val rdd2 = sc.parallelize(List(("jerry", 2), ("tom", 1), ("shuke", 2)))

    val rdd = rdd1.cogroup(rdd2)

    rdd.foreach(x => println(x))

  }

  /**
    * reduce聚合
    * @param sc
    */
  def reduce(sc : SparkContext) : Unit = {

    val rdd1 = sc.parallelize(List(1, 2, 3, 4, 5))
    val rdd2 = rdd1.reduce(_ + _)
    println(rdd2.toString)
  }

  /**
    * reduceByKey
    * 按key进行聚合
    * @param sc
    */
  def reduceByKey(sc : SparkContext) : Unit = {

    val rdd1 = sc.parallelize(List(("tom", 1), ("jerry", 3), ("kitty", 2),  ("shuke", 1)))
    val rdd2 = sc.parallelize(List(("jerry", 2), ("tom", 3), ("shuke", 2), ("kitty", 5)))

    val rdd3 = rdd1.union(rdd2)

    val rdd4 = rdd3.reduceByKey(_ + _)

    rdd4.foreach(x => println(x.toString()))
  }

  /**
    * 按value的升序或者降序排序
    * @param sc
    */
  def sortByKeyDescAsc(sc : SparkContext) : Unit = {

    val rdd1 = sc.parallelize(List(("tom", 1), ("jerry", 3), ("kitty", 2),  ("shuke", 1)))
    val rdd2 = sc.parallelize(List(("jerry", 2), ("tom", 3), ("shuke", 2), ("kitty", 5)))
    val rdd3 = rdd1.union(rdd2)
    //按key进行聚合
    val rdd4 = rdd3.reduceByKey(_ + _)
    //按value的降序排序
    val rdd5 = rdd4.map(t => (t._2, t._1)).sortByKey(true).map(t => (t._2, t._1))

    rdd5.foreach(x => println(x))
  }
}
