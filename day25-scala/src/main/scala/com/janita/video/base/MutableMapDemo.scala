package com.janita.video.base

import scala.collection.mutable.Map

/**
  * Created by Janita on 2017-05-12 22:35
  */
object MutableMapDemo {


  def main(args: Array[String]): Unit = {

    val scores = Map("tom" -> 85, "jerry" -> 99, "kitty" -> 90)

    scores("tom") = 88 ;
    println(scores("tom"))

    scores += ("tom" -> 80, "suke" -> 60)

    println(scores("kitty"))

  }
}
