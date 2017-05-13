package com.janita.video.clazz

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Janita on 2017-05-13 10:31
  */
object SingletonDemo {

  def main(args: Array[String]): Unit = {
  }

}

object SessionFactory {

  var counts = 5
  val sessions = new ArrayBuffer[Session]()
  while (counts > 0){
    sessions += new Session
    counts -= 1
  }

  def getSession() : Session = {
    sessions.remove(0)
  }
}

class Session{}

