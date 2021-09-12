package com.jandy.akkapractice.package1.statesbehaviours.prioritisation

import akka.actor.ActorSystem
import akka.dispatch.{PriorityGenerator, UnboundedPriorityMailbox}
import com.typesafe.config.Config


class MyPriorityMailbox(settings:
                             ActorSystem.Settings, config: Config) extends
  UnboundedPriorityMailbox (
    PriorityGenerator{
      case x: Int => 1
      case x: String => 0
      case x: Long => 2
      case _ => 3
    })