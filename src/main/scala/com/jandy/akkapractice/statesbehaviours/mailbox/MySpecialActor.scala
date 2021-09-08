package com.jandy.akkapractice.statesbehaviours.mailbox

import akka.actor.Actor

class MySpecialActor extends Actor{
  override def receive: Receive = {
    case msg: String => println(s"msg is $msg")
  }

}
