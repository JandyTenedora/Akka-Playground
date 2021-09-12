package com.jandy.akkapractice.package2.supervisionmonitoring.collectresponse

import akka.actor.Actor

class DoubleActor extends Actor{
  def receive = {
    case DoubleValue(number) =>
      println(s"${self.path.name} got the number $number")
      sender ! Response(number * 2)
  }

}
