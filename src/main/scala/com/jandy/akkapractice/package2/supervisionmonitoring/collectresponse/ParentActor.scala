package com.jandy.akkapractice.package2.supervisionmonitoring.collectresponse

import akka.actor.{Actor, ActorRef, Props}

class ParentActor extends Actor{
  val random = new scala.util.Random
  var childs =
    scala.collection.mutable.ListBuffer[ActorRef]()
  def receive = {
    case CreateChild =>
      childs ++= List(context.actorOf(Props[DoubleActor]))
    case Send =>
      println(s"Sending messages to child")
      childs.zipWithIndex map {case (child,value) =>
      child ! DoubleValue(random.nextInt(10))}
    case Response(x) => println(s"Parent: Response from child ${sender.path.name} is $x")
  }
}
