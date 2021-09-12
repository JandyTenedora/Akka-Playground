package com.jandy.akkapractice.package1.statesbehaviours.prioritisation

import akka.actor.{ActorSystem, Props}

object MyPriorityActorMailboxApp extends App{
  val actorSystem= ActorSystem("HelloAkka")
  val myPriorityActor = actorSystem.actorOf(Props[MyPriorityActor].withDispatcher("priority-dispatcher"))
  myPriorityActor ! 6.0
  myPriorityActor ! 1
  myPriorityActor ! 5.0
  myPriorityActor ! "First to be processed is string, then int, then long then everything else"
  myPriorityActor ! true

}
