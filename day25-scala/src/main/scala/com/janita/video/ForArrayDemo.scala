package com.janita.video

/**
  * Created by Janita on 2017-05-12 22:24
  */
object ForArrayDemo {


  def main(args: Array[String]): Unit = {

    val arr = Array(1,2,3,4,5,6,7,8)

//    for(i <- arr)
//      println(i)

    for (i <- (0 until arr.length).reverse)
      println(arr(i))
  }
}
