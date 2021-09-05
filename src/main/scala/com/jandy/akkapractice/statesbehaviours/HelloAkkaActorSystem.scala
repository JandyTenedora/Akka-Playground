package com.jandy.akkapractice.statesbehaviours

import akka.actor.{ActorSystem, Props}

object HelloAkkaActorSystem extends App{
  val actorSystem = ActorSystem("HelloAkka")
  val actor = actorSystem.actorOf(Props(classOf[SummingActorWithConstructor],10), "summingactorwithArgument")
  println(actor.path)
}
