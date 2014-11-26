organization  := "de.khamrakulov"

version       := "0.1"

scalaVersion  := "2.11.2"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= {
  val akkaV = "2.3.6"
  val sprayV = "1.3.2"
  Seq(
    "io.spray"            %%  "spray-can"                 % sprayV,
    "io.spray"            %%  "spray-routing"             % sprayV,
    "io.spray"            %%  "spray-json"                % "1.3.1",
    "io.spray"            %%  "spray-testkit"             % sprayV    % "test",
    "com.typesafe.akka"   %%  "akka-actor"                % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"              % akkaV     % "test",
    "org.specs2"          %%  "specs2-core"               % "2.3.11"  % "test"
  )
}

seq(Revolver.settings: _*)
