package com.jandy.akkapractice.package1.statesbehaviours.behaviours

import akka.actor.Actor

class BecomeUnbecome extends Actor{
  def receive: Receive = {
    case true => context.become(isStateTrue)
    case false => context.become(isStateFalse)
    case _ => println("Unaccounted for message")
  }

  def isStateTrue: Receive = {
    case msg: String => println(s"$msg")
    case false => context.become(isStateFalse)
  }

  def isStateFalse: Receive = {
    case msg: Int => println(s"$msg")
    case true => context.become(isStateTrue)
  }

}
