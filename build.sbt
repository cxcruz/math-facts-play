lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .enablePlugins(SbtWeb)
  .settings(
    name := """math-facts-play""",
    version := "0.1",
    scalaVersion := "2.11.4",
    resolvers += "sonatype releases" at "http://oss.sonatype.org/content/repositories/releases",
    libraryDependencies ++= Seq(
      jdbc,
      anorm,
      cache,
      ws,
      "org.scalikejdbc"      %% "scalikejdbc"                     % scalikejdbcVersion,
      "org.scalikejdbc"      %% "scalikejdbc-config"              % scalikejdbcVersion,
      "org.scalikejdbc"      %% "scalikejdbc-play-plugin"         % scalikejdbcPlayVersion,
      "org.scalikejdbc"      %% "scalikejdbc-play-fixture-plugin" % scalikejdbcPlayVersion,
      "com.h2database"       %  "h2"                              % h2Version,
      "org.hibernate"        %  "hibernate-core"                  % "4.3.7.Final",
      "org.json4s"           %% "json4s-ext"                      % "3.2.11",
      "com.github.tototoshi" %% "play-json4s-native"              % "0.3.0",
      "com.github.tototoshi" %% "play-flyway"                     % "1.2.0",
      "org.scalikejdbc"      %% "scalikejdbc-test"                % scalikejdbcVersion  % "test",
      "postgresql"           %  "postgresql"                      % "9.1-901.jdbc4"
    ),
    initialCommands := """
      import scalikejdbc._, config._
      import models._, utils._
      DBs.setupAll
      implicit val autoSession = AutoSession
    """
  )
  

lazy val scalikejdbcVersion = "2.2.+"
lazy val scalikejdbcPlayVersion = "2.3.+"
lazy val h2Version = "1.4.+"
