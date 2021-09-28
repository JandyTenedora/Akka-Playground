package com.jandy.akkapractice.package9.http.fileupload

import akka.http.scaladsl.settings.ServerSettings
import com.typesafe.config.ConfigFactory

object UploadingFileServerApplication extends App {
  UploadingFileServer.startServer("0.0.0.0", 8088, ServerSettings(ConfigFactory.load))
}
