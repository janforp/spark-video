package com.janita.video.base

/**
  * Created by Janita on 2017-05-12 22:06
  *  在函数式编程语言中，函数是“头等公民”，它可以像任何其他数据类型一样被传递和操作
  * 案例：首先定义一个方法，再定义一个函数，然后将函数传递到方法里面
  */
object MethodAndFunctionDemo {

  /**
    定义一个方法
  方法methodOne参数要求是一个函数，函数的参数必须是两个Int类型
  返回值类型也是Int类型
    * @param f
    * @return
    */
  def methodOne(f :(Int, Int) => Int) : Int = {
    f(2, 6)
  }

  //定义一个函数functionOne，参数是两个Int类型，返回值是一个Int类型(可以省略)
  val functionOne = (x: Int, y: Int) => x + y

  val functionTwo = (m: Int, n: Int) => m*n

  def main(args: Array[String]): Unit = {

    val resultOne = methodOne(functionOne)
    println(resultOne)

    val resultTwo = methodOne(functionTwo)
    println(resultTwo)
  }

  //下划线将方法变成了 函数
  val functionThree = methodOne _
}
