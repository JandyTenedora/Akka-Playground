package com.jandy.akkapractice.package1.statesbehaviours.stop

import akka.actor.Actor

case object Stop

class ShutdownActor extends Actor {
  override def receive: Receive = {
    case msg: String => println(s"$msg")
    case Stop => context.stop(self)
  }

}
