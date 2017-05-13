package com.janita.video.base

/**
  * Created by Janita on 2017-05-12 21:50
  */
object ConditionDemo {

  def main(args: Array[String]): Unit = {

    val x = 1

    val y = if (x > 0) 1 else -1

    println(y)

    val z = if(x>1) 1 else "error"

    println(z)

    val m = if (x > 2) 1

    println(m)
  }

}
