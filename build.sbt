ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "property-checking-talk"
  )

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.1" % Test
libraryDependencies += "com.github.alexarchambault" %% "scalacheck-shapeless_1.15" % "1.3.0" % Test
val circeVersion = "0.14.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)
