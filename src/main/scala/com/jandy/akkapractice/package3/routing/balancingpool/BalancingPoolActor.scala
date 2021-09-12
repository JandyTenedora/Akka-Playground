package com.jandy.akkapractice.package3.routing.balancingpool

import akka.actor.Actor

class BalancingPoolActor extends Actor{
  override def receive: Receive = {
    case msg: String => println(s"Current path is ${self.path.name}")
    case _ => println("Undefined message")
  }

}
