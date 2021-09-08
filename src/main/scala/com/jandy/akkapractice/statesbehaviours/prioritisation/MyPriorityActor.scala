package com.jandy.akkapractice.statesbehaviours.prioritisation

import akka.actor.Actor

class MyPriorityActor extends Actor{
  def receive: PartialFunction[Any,Unit] = {
    case x: Int => println(x)
    case y: String => println(y)
    case z: Long => println(z)
    case a => println(a)
  }

}
