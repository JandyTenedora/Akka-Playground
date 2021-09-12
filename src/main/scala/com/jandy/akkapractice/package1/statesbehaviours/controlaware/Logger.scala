package com.jandy.akkapractice.package1.statesbehaviours.controlaware

import akka.actor.Actor

class Logger extends Actor{
  def receive = {
    case MyControlMessage => println("This gets processed first")
    case x => println(x.toString)
  }

}
