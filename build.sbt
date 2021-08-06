enablePlugins(ScalaJSPlugin)

name := "dynamic-revo"

version := "0.1-SNAPSHOT"

scalaVersion := "3.0.1"

scalaJSUseMainModuleInitializer := true

libraryDependencies += ("org.scala-js" %%% "scalajs-dom" % "1.1.0").cross(
  CrossVersion.for3Use2_13
)
