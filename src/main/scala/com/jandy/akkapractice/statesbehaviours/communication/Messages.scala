package com.jandy.akkapractice.statesbehaviours.communication

import akka.actor.ActorRef

object Messages {
  case class Done(randomNumber: Int)
  case object GiveMeRandomNumber
  case class Start(actorRef: ActorRef)

}
