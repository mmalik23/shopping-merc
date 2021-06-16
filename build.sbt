lazy val phoneCompany = (project in file(".")).settings(
  Seq(
    name := "shop",
    version := "1.0",
    scalaVersion := "2.13.5"
  )
)

libraryDependencies ++= Seq(
  "org.scalatest"          %% "scalatest"            % "3.1.0" % Test,
)