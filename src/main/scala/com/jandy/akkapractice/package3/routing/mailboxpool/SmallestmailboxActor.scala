package com.jandy.akkapractice.package3.routing.mailboxpool

import akka.actor.Actor

class SmallestmailboxActor extends Actor{
  override def receive: Receive = {
    case msg: String => println(s"I am ${self.path.name}")
    case _ => println("unspecified message")
  }

}
