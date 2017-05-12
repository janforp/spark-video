package com.janita.video

/**
  * Created by Janita on 2017-05-12 22:02
  */
object MethodDemo {

  def main(args: Array[String]): Unit = {

    plus()

    println(fun(1,3))
  }

  /**
    * 方法
    */
  def plus() : Unit = {

    val a = 1
    val b = 2
    println(a.+(b))
  }

  /**
    * 函数
    */
  val fun = (x : Int, y: Int) => x+ y

}
