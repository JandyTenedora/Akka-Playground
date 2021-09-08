package com.jandy.akkapractice.statesbehaviours.mailbox

import akka.actor.{ActorRef, ActorSystem}
import akka.dispatch.{MailboxType, MessageQueue, ProducesMessageQueue}
import com.typesafe.config.Config

class MyUnboundedMailbox extends MailboxType
with ProducesMessageQueue[MyMessageQueue] {
  def this(settings: ActorSystem.Settings, config: Config) = {
    this()
  }

  final override def create(owner: Option[ActorRef], system: Option[ActorSystem]):MessageQueue = new MyMessageQueue()
}
