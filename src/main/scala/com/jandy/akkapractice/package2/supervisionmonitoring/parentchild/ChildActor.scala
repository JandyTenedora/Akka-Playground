package com.jandy.akkapractice.package2.supervisionmonitoring.parentchild

import akka.actor.Actor

class ChildActor extends Actor{
  override def receive: Receive = {
    case Greet(msg) => println(s"My parent [${self.path.parent}] greeted to me [${self.path}] $msg")
  }
}
