package com.jandy.akkapractice.package1.statesbehaviours.stop

import akka.actor.{ActorSystem, Props}

object ShutdownApp extends App{
  val actorSystem = ActorSystem("Akka")
  val shutdownActor = actorSystem.actorOf(Props[ShutdownActor])
  shutdownActor ! "test"
  shutdownActor ! Stop
  shutdownActor ! "testing that this shouldn't send"
}
