package com.janita.video.base

/**
  * Created by Janita on 2017-05-12 22:32
  */
object MapDemo {

  def main(args: Array[String]): Unit = {


    val scores = Map("tom" -> 85, "jerry" -> 99, "kitty" -> 90)

    val fenshu = Map(("tom",50),("jan",100))

    println(scores("kitty"))

    println(fenshu.getOrElse("suke", 0))
  }

}
