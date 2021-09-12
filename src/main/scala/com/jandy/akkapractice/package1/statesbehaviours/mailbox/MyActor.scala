package com.jandy.akkapractice.package1.statesbehaviours.mailbox

import akka.actor.{Actor, ActorRef}

class MyActor extends Actor{
  override def receive: Receive = {
    case (msg: String, actorRef: ActorRef) => actorRef ! msg
    case msg => println(msg)
  }

}
