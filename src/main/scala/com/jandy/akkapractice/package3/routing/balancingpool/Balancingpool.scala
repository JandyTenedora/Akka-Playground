package com.jandy.akkapractice.package3.routing.balancingpool

import akka.actor.{Actor, ActorSystem, Props}
import akka.routing.BalancingPool

object Balancingpool extends App{
  val actorSystem = ActorSystem("Akka")
  val router =
    actorSystem.actorOf(BalancingPool(5).props(Props[BalancingPoolActor]))
    for (i <- 1 to 5){
      router ! s"Hello $i"
    }
}
