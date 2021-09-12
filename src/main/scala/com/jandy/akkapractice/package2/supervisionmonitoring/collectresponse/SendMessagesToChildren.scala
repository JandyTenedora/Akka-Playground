package com.jandy.akkapractice.package2.supervisionmonitoring.collectresponse

import akka.actor.{ActorSystem, Props}

case class DoubleValue(x:Int)
case object CreateChild
case object Send
case class Response(x:Int)

object SendMessagesToChildren extends App{
  val actorSystem = ActorSystem("Akka")
  val parent =
    actorSystem.actorOf(Props[ParentActor], "parent")
  parent ! CreateChild
  parent ! CreateChild
  parent ! CreateChild
  parent ! Send

}
