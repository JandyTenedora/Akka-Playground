package com.jandy.akkapractice.package5.devops.logging

import akka.actor.{ActorSystem, Props}

object Logging extends App{
  val actorSystem = ActorSystem("Akka")
  val loggingActor = actorSystem.actorOf(Props[LoggingActor], "loggingActor")
  loggingActor ! (10,12)
  loggingActor ! "Hello message"
  actorSystem.terminate()
}
