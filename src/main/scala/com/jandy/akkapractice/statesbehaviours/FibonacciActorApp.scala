package com.jandy.akkapractice.statesbehaviours

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.Await
import scala.concurrent.duration._

object FibonacciActorApp extends App{
  implicit val timeout = Timeout(5 seconds)
  val actorSystem = ActorSystem("HelloAkka")
  val actor = actorSystem.actorOf(Props[FibonacciActor])
  val future = (actor ? 4).mapTo[Int]
  val fibonacciNumber = Await.result(future,10 seconds)
  println(fibonacciNumber)

}
