package com.jandy.akkapractice.package2.supervisionmonitoring.parentchild

import akka.actor.{ActorSystem, Props}

case object CreateChild
case class Greet(msg: String)
object ParentChild extends App{
  val actorSystem = ActorSystem("SupervisionSystem")
  val parent = actorSystem.actorOf(Props[ParentActor], "parent")
  parent ! CreateChild
}
