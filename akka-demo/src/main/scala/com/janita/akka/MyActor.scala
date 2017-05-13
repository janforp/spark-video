package com.janita.akka

import scala.actors.Actor

/**
  * Created by Janita on 2017-05-13 15:21
  */
class MyActor extends Actor{

  override def act(): Unit = {

    while (true){
      receive{
        case "start" => {

          println("starting ...")
          Thread.sleep(5000)
          println("started")
        }

        case "stop" => {
          println("stopping ...")
          Thread.sleep(5000)
          println("stopped ...")
        }
      }
    }
  }
}

object MyActor {

  def main(args: Array[String]): Unit = {

    val actor = new MyActor
    actor.start()
    actor ! "start"
    actor ! "stop"

    println("发送消息完成! ")
  }
}
