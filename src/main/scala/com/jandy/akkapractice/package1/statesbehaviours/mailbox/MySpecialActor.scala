package com.jandy.akkapractice.package1.statesbehaviours.mailbox

import akka.actor.Actor

class MySpecialActor extends Actor{
  override def receive: Receive = {
    case msg: String => println(s"msg is $msg")
  }

}
