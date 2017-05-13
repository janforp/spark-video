package com.janita.video.base

/**
  * Created by Janita on 2017-05-12 22:27
  * yield关键字将原始的数组进行转换会产生一个新的数组，原始的数组不变
  */
object ArrayYieldDemo {

  def main(args: Array[String]) {
    //定义一个数组
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    //将偶数取出乘以10后再生成一个新的数组
    val res = for (e <- arr if e % 2 == 0) yield e * 10
    println(res.toBuffer)

    //更高级的写法,用着更爽
    //filter是过滤，接收一个返回值为boolean的函数
    //map相当于将数组中的每一个元素取出来，应用传进去的函数
    val r = arr.filter(_ % 2 == 0).map(_ * 10)
    println(r.toBuffer)

    println(arr.sum)
    println(arr.max)
    println(arr.min)
    println(arr.reverse.toBuffer)




  }
}
