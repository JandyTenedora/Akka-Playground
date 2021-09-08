package com.jandy.akkapractice.statesbehaviours.controlaware

import akka.actor.Actor

class Logger extends Actor{
  def receive = {
    case MyControlMessage => println("This gets processed first")
    case x => println(x.toString)
  }

}
