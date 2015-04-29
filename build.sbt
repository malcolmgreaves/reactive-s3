name := "reactive-s3"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.6"

organization := "com.nitro"

resolvers ++= Seq("Typesafe repository releases" at "http://repo.typesafe.com/typesafe/releases/",
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases")

// Temporary workaround until we properly publish stream collections
lazy val streamCollections = ProjectRef(uri("git://github.com/nitro/streamcollections.git"), "streamcollections")

lazy val main = Project(
  id = "reactive-s3",
  base = file(".")
).dependsOn(
  streamCollections
  )

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-java-sdk" % "1.9.24",
  "com.typesafe.play" %% "play-iteratees" % "2.3.8",
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "org.joda" % "joda-convert" % "1.6",
  "com.jsuereth" %% "scala-arm" % "1.4",
  "org.specs2" %% "specs2-core" % "3.0.1" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")

scalariformSettings
