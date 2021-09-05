package com.jandy.akkapractice.statesbehaviours.communication

import akka.actor.Actor


class QueryActor extends Actor {
  import Messages._
  override def receive: Receive = {
    case Start(actorRef) => println(s"send me the next random number")
      actorRef  ! GiveMeRandomNumber
    case Done(randomNumber)   => println(s"receiived a random number $randomNumber")
  }
}
