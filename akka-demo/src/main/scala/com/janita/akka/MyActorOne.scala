package com.janita.akka

import scala.actors.Actor

/**
  * Created by Janita on 2017-05-13 15:17
  */
object MyActorOne extends Actor{

  override def act(): Unit = {
    for (i <- 1 to 10) {
      println("actor - 1  " + i)
      Thread.sleep(2000)
    }
  }
}

object MyActorTwo extends Actor {

  override def act(): Unit = {
    for (i <- 1 to 10) {
      println("actor - 2  " + i)
      Thread.sleep(2000)
    }
  }
}

object ActorTest extends App {

  MyActorOne.start()
  MyActorTwo.start()
}
