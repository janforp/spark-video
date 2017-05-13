package com.janita.akka


import scala.actors.Actor

/**
  * Created by Janita on 2017-05-13 15:28
  */
class AppleActor extends Actor{

  override def act(): Unit = {

    while (true) {

      receive {

        case "start" => println("starting ")
        case SyncMsg(id, msg) => {
          println(id + ", sync " + msg)
          Thread.sleep(5000)
          sender ! ReplyMsg(3,"finished")
        }
        case AsyncMsg(id ,msg) => {
          println(id + ",async " + msg)
          Thread.sleep(5000)
        }
      }
    }
  }
}

object AppleActor {

  def main(args: Array[String]): Unit = {

    val a = new AppleActor
    a.start()

    a ! AsyncMsg(1, "nihao")
    println("发送异步消息成功")

    val content = a !? SyncMsg(2 , "同步消息")
    println(content)

    val reply = a !! SyncMsg(2, "hello actor")
    println(reply.isSet)
    //println("123")
    val c = reply.apply()
    println(reply.isSet)
    println(c)
  }
}

case class SyncMsg(id : Int, msg: String)
case class AsyncMsg(id : Int, msg: String)
case class ReplyMsg(id : Int, msg: String)
