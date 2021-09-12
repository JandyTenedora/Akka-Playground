package com.jandy.akkapractice.package2.supervisionmonitoring.parentchild

import akka.actor.{Actor, Props}

class ParentActor extends Actor{
  def receive = {
    case CreateChild =>
      val child = context.actorOf(Props[ChildActor], "child")
      child ! Greet("Hello child")
  }

}
