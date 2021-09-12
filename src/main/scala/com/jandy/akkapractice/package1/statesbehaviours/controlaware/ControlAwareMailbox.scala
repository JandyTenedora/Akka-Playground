package com.jandy.akkapractice.package1.statesbehaviours.controlaware

import akka.dispatch.ControlMessage
import akka.actor.{Props,Actor, ActorSystem}
case object MyControlMessage extends ControlMessage


object ControlAwareMailbox extends App {
  val actorSystem = ActorSystem("HelloAkka")
  val actor = actorSystem.actorOf(Props[Logger].withDispatcher("control-aware-dispatcher"))
  actor ! "hello"
  actor ! "this should be processed"
  actor ! "after the control message"
  actor ! MyControlMessage
}
