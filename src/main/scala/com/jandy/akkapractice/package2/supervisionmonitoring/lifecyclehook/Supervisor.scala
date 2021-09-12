package com.jandy.akkapractice.package2.supervisionmonitoring.lifecyclehook

import akka.actor.SupervisorStrategy.{Escalate, Restart}
import akka.actor.{Actor, OneForOneStrategy, Props}

import scala.concurrent.duration.DurationInt

class Supervisor extends Actor {
  override val supervisorStrategy = OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange =  1 minute)
  {
    case _: ArithmeticException => Restart
    case t => super.supervisorStrategy.decider.applyOrElse(t, (_:Any) => Escalate)
  }

  def receive = {
    case (props: Props, name: String) =>
      sender ! context.actorOf(props,name)
    case StopActor(actorRef)  => context.stop(actorRef)
  }

}
