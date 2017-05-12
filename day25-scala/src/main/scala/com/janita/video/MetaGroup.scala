package com.janita.video

/**
  * Created by Janita on 2017-05-12 22:40
  */
object MetaGroup {


  def main(args: Array[String]): Unit = {

    val t = ("hadoop", 3.14, 65535)

    println(t._3)

    val arr = Array(("tom",88),("jerry",95))

    val map = arr.toMap

    println(map("tom"))

  }
}
