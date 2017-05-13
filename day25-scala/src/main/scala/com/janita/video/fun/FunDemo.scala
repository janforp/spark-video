package com.janita.video.fun

/**
  * Created by Janita on 2017-05-13 14:42
  */
object FunDemo {

  def main(args: Array[String]): Unit = {

    def f2(x :Int) = x + 2

    val f3 = (x :Int) => x*3

    val f4: (Int) => Int = {x => x* 4}

    val f4a : (Int) => Int = _* 4

    val f5 = (_ : Int) * 5

    val list = List(1, 2, 3, 4, 5)

    var new_list : List[Int] = null


  }

}
