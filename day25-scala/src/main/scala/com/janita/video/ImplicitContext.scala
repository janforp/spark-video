package com.janita.video

/**
  * Created by Janita on 2017-05-13 14:54
  */
object ImplicitContext {
  //implicit def girl2Ordered(g : Girl) = new Ordered[Girl]{
  //  override def compare(that: Girl): Int = if (g.faceValue > that.faceValue) 1 else -1
  //}

  implicit object OrderingGirl extends Ordering[Girl]{
    override def compare(x: Girl, y: Girl): Int = if (x.faceValue > y.faceValue) 1 else -1
  }
}

class Girl(var name: String, var faceValue: Double){
  override def toString: String = s"name : $name, faveValue : $faceValue"
}

//class MissRight[T <% Ordered[T]](f: T, s: T){
//  def choose() = if(f > s) f else s
//}
//class MissRight[T](f: T, s: T){
//  def choose()(implicit ord: T => Ordered[T]) = if (f > s) f else s
//}

class MissRight[T: Ordering](val f: T, val s: T){
  def choose()(implicit ord: Ordering[T]) = if(ord.gt(f, s)) f else s
}

object MissRight {
  def main(args: Array[String]) {
    import ImplicitContext.OrderingGirl
    val g1 = new Girl("yuihatano", 99)
    val g2 = new Girl("jzmb", 98)
    val mr = new MissRight(g1, g2)
    val result = mr.choose()
    println(result)
  }
}