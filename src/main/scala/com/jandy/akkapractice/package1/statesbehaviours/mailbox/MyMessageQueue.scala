package com.jandy.akkapractice.package1.statesbehaviours.mailbox

import akka.actor.ActorRef
import akka.dispatch.{Envelope, MessageQueue}

import java.util.concurrent.ConcurrentLinkedQueue

class MyMessageQueue extends MessageQueue{
  private final val queue = new ConcurrentLinkedQueue[Envelope]()
  override def enqueue(receiver: ActorRef, handle: Envelope): Unit = {
    if(handle.sender.path.name == "MyActor"){
      handle.sender ! "Processing your request"
      queue.offer(handle)
    }
    else handle.sender ! "Can't process your request, unknown sender"
  }

  override def dequeue(): Envelope = queue.poll()
  override def numberOfMessages: Int = queue.size
  override def hasMessages: Boolean = !queue.isEmpty

  override def cleanUp(owner: ActorRef, deadLetters: MessageQueue): Unit = {
    while (hasMessages) {
      deadLetters.enqueue(owner, dequeue())
    }
  }

}
