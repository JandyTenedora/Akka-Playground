package com.jandy.akkapractice.package9.http.simpleserver

import akka.http.scaladsl.settings.ServerSettings
import com.typesafe.config.ConfigFactory

object httpServerApplication extends App {
  httpServer.startServer("0.0.0.0", 8088,
    ServerSettings(ConfigFactory.load))
}
