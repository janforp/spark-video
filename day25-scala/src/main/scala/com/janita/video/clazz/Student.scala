package com.janita.video.clazz

import java.io.IOException

/**
  * Created by Janita on 2017-05-13 10:17
  */
class Student(val name : String, val age : Int) {

  println("执行构造器")

  try{

    println("读取文件")
    throw new IOException("io exception")
  }catch {

      case e : NullPointerException => println("打印异常Exception : " + e)
      case e : IOException => println("打印异常Exception : " + e)
  }finally {
      println("执行finally部分")
  }

  private var gender = "male"

  def this(name : String, age : Int, gender : String){
    this(name,age)
    println("执行辅助构造器")
    this.gender = gender
  }
}
