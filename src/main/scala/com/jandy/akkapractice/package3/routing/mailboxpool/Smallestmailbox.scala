package com.jandy.akkapractice.package3.routing.mailboxpool

import akka.actor.{ActorSystem, Props}
import akka.routing.SmallestMailboxPool

object Smallestmailbox extends App{
  val actorSystem = ActorSystem("Akka")
  val router = actorSystem.actorOf(SmallestMailboxPool(5).props(Props[SmallestmailboxActor]))
  for (i <- 1 to 5){
    router ! s"Hello $i"
  }
}
