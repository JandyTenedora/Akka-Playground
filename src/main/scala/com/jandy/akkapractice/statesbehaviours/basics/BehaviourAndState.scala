package com.jandy.akkapractice.statesbehaviours.basics

import akka.actor.Actor

class SummingActor extends Actor{
  var sum = 0

  override def receive: Receive = {
    case x: Int => sum = sum + x
      println(s"my state as sum is $sum")
    case _ => println("what are you talking about?")
  }

}

class SummingActorWithConstructor(initialSum: Int) extends Actor{
  var sum = 0
  override def receive: Receive = {
    case x: Int => sum = initialSum + sum + x
      println(s"state as sum is now $sum")
    case _ => println("still don't know what you're talking about")
  }
}