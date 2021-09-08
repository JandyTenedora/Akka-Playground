package com.jandy.akkapractice.statesbehaviours.basics

import akka.actor.{ActorSystem, Props}
import akka.util.Timeout
import akka.pattern.ask

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

object FibonacciActorApp extends App {
  implicit val timeout = Timeout(5 seconds)
  val actorSystem = ActorSystem("HelloAkka")
  val actor = actorSystem.actorOf(Props[FibonacciActor])
  val future = (actor ? 4).mapTo[Int]
  val fibonacciNumber = Await.result(future, 10 seconds)
  println(fibonacciNumber)

}
