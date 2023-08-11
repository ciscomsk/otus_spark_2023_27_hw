ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "otus_spark_hw"
  )

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "3.4.1" % Provided
)