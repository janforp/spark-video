package com.janita.video.base

import scala.collection.mutable.ListBuffer

/**
  * Created by Janita on 2017-05-12 22:49
  */
object MutListDemo extends App{

  val lst0 = ListBuffer[Int](1,2,3)

  val lst1 = new ListBuffer[Int]

  lst1 += 4
  lst1.append(5)

  println(lst1)

  lst0 ++= lst1
  println(lst0)

  val lst2 = lst0 ++ lst1
  println(lst2)

  val lst3 = lst0 :+ 5
  println(lst3)

}
