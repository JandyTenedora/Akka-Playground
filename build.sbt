scalaVersion := "2.11.7"

version := "1.0"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.4.4"
libraryDependencies += "com.typesafe.akka" % "akka-testkit_2.11" % "2.4.4"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.1"
libraryDependencies += "com.typesafe.akka" % "akka-persistence_2.11" % "2.4.17"
libraryDependencies += "org.iq80.leveldb"  % "leveldb" % "0.7"
libraryDependencies += "com.typesafe.akka" %  "akka-http_2.11" % "10.0.5"