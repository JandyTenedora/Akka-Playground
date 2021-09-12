package com.jandy.akkapractice.package2.supervisionmonitoring.lifecyclehook
import akka.actor._
import akka.actor.SupervisorStrategy._
import akka.util.Timeout
import scala.concurrent.Await
import scala.concurrent.duration._
import akka.pattern.ask

case object Error
case class StopActor(actorRef: ActorRef)

object ActorLifeCycle extends App{
  implicit val timeout = Timeout(2 seconds)
  val actorSystem = ActorSystem("Supervision")
  val supervisor = actorSystem.actorOf(Props[Supervisor], "supervisor")
  val childFuture = supervisor ? (Props(new LifeCycleActor), "LifeCycleActor")
  val child = Await.result(childFuture.mapTo[ActorRef], 2 seconds)
  child ! Error
  Thread.sleep(1000)
  supervisor ! StopActor(child)
}
