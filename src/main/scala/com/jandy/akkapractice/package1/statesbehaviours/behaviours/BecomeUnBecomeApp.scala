package com.jandy.akkapractice.package1.statesbehaviours.behaviours

import akka.actor.{ActorSystem, Props}

object BecomeUnBecomeApp extends App{
  val actorSystem = ActorSystem("Akka")
  val becomeUnbecome = actorSystem.actorOf(Props[BecomeUnbecome])
  becomeUnbecome ! true
  becomeUnbecome ! "test"
  becomeUnbecome ! 2
  becomeUnbecome ! "bloop"
  becomeUnbecome ! false
  becomeUnbecome ! "rotator"
  becomeUnbecome ! 2
  becomeUnbecome ! 4

}
