package com.jandy.akkapractice.statesbehaviours.communication

import akka.actor.{ActorSystem, Props}

object Communication extends App{
  import Messages._
  val actorSystem = ActorSystem("HelloAkka")
  val randomNumberGenerator = actorSystem.actorOf(Props[RandomNumberGeneratorActor], "rngactor")
  val queryActor = actorSystem.actorOf(Props[QueryActor], "queryactor")
  queryActor ! Start(randomNumberGenerator)
}
