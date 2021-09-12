package com.jandy.akkapractice.package5.devops.logging

import akka.actor.{ActorSystem, Props}

import akka.actor.{Actor, ActorLogging}

class LoggingActor extends Actor with ActorLogging{
  def receive = {
    case (a: Int, b: Int) => {
      log.info(s"sum of $a and $b is ${a+b}")
    }
    case msg => log.warning(s"Not sure what you're talking about : $msg")
  }

}

object Logging extends App{
  val actorSystem = ActorSystem("Akka")
  val loggingActor = actorSystem.actorOf(Props[LoggingActor], "loggingActor")
  loggingActor ! (10,12)
  loggingActor ! "Hello message"
  actorSystem.terminate()
}
