name := "ScalaPractice"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.6"

scalacOptions ++= Seq(
  "-Xprint:typer",
  "-Ypartial-unification"
)

libraryDependencies += "com.softwaremill.sttp" %% "core" % "1.2.1"
libraryDependencies += "com.softwaremill.sttp" %% "async-http-client-backend-future" % "1.2.1"

libraryDependencies += "org.typelevel" %% "cats-core" % "1.0.1"
libraryDependencies += "org.typelevel" %% "cats-free" % "1.0.1"
libraryDependencies += "org.typelevel" %% "cats-effect" % "1.0.0-RC2"