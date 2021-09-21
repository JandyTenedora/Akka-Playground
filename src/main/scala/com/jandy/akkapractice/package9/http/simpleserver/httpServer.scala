package com.jandy.akkapractice.package9.http.simpleserver

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.HttpApp

object httpServer extends HttpApp {
  def route = {
    pathPrefix("v1") {
      path("id" / Segment) {
        id =>
          get {
            complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, s"<h1> Hello $id from Akka</h1>"))
          } ~
            post {
              entity(as[String]) {
                entity => complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, s"<b> Thanks $id for posting your messages <i> $entity</i></b>"))
              }
            }
      }
    }
  }


}
