package com.jandy.akkapractice.package1.statesbehaviours.basics

import akka.actor.{ActorSystem, Props}

object HelloAkkaActorSystem extends App {
  val actorSystem = ActorSystem("HelloAkka")
  val actor = actorSystem.actorOf(Props(classOf[SummingActorWithConstructor], 10), "summingactorwithArgument")
  println(actor.path)
}
