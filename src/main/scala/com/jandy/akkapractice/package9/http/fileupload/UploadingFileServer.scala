package com.jandy.akkapractice.package9.http.fileupload

import akka.http.scaladsl.model.Multipart
import akka.http.scaladsl.server.HttpApp
import akka.stream.scaladsl.Framing
import akka.util.ByteString

import scala.concurrent.duration._
object UploadingFileServer extends HttpApp {
  val route =
    extractRequestContext { ctx =>
      implicit val materializer = ctx.materializer
      implicit val ec = ctx.executionContext

      path("regularupload") {
        entity(as[Multipart.FormData]) {
          formData =>
            val partsFuture = formData.parts.mapAsync(1) {
              b =>
                b.toStrict(2 seconds).map(
                  _.entity.data.utf8String
                )
            }.runFold(List.empty[String])(_ :+ _)

            onSuccess(partsFuture) {
              allParts =>
                complete {
                  val wholeFile = allParts.mkString
                  s"Regular upload: submitted file has ${wholeFile.split("\n").size} lines"
                }
            }
        }
      } ~
        path("streamupload") {
          entity(as[Multipart.FormData]) {
            formData =>
              val linesFuture = formData.parts.mapAsync(1) {
                b =>
                  b.entity.dataBytes
                    .via(Framing.delimiter(ByteString("\n"),
                      1024, allowTruncation = true))
                    .map(_ => 1)
                    .runReduce(_ + _)
              }.runReduce(_ + _)
              onSuccess(linesFuture) {
                lines =>
                  complete {
                    s"Stream upload: submitted file has $lines lines"
                  }
              }
          }
        }
    }
}

