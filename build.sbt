//import coursier //.{ Cache => CoursierCache, _ }

name := "Templatey"

version := "0.1"

scalaVersion := "2.12.4"

val argonautVersion = "6.2"
val catsVersion = "1.0.0-RC1"
val catsEffectVersion = "0.5"
val circeVersion = "0.8.0"
val doobieVersion = "0.4.4"
val http4sVersion = "0.17.5"
val monocleVersionScalaz = "1.4.0"
val monocleVersionCats = "1.5.0-cats-M1"
val scalazVersion = "7.2.16"
val scalacheckVersion = "1.13.4"
val specsVersion = "4.0.0"

val repositories = Seq(
  coursier.Cache.ivy2Local,
  coursier.MavenRepository("https://repo1.maven.org/maven2")
)

val start = coursier.Resolution(
  Set(
    coursier.Dependency(
      coursier.Module("org.typelevel", "cats-core_2.12"), catsVersion
    )
  )
)

//repositories: Seq[coursier.core.Repository] = List(IvyRepository(Pattern(List(Const(file://), Var(user.home), Const(/local/), Var(organisation), Const(/), Var(module), Const(/), Opt(WrappedArray(Const(scala_), Var(scalaVersion), Const(/))), Opt(WrappedArray(Const(sbt_), Var(sbtVersion), Const(/))), Var(revision), Const(/), Var(type), Const(s/), Var(artifact), Opt(WrappedArray(Const(-), Var(classifier))), Const(.), Var(ext))),None,None,true,true,true,true,None), MavenRepository(https://repo1.maven.org/maven2,None,true,None))


libraryDependencies ++= Seq(
  "io.get-coursier" %% "coursier" % "1.0.1",
  "io.get-coursier" %% "coursier-cache" % "1.0.1",

  // Scalaz
//  "org.scalaz" %% "scalaz-core" % scalazVersion,
//  "org.scalaz" %% "scalaz-effect" % scalazVersion,
//  "org.scalaz" %% "scalaz-concurrent" % scalazVersion,

  // Cats
//  "org.typelevel" %% "cats-core" % catsVersion,
  //"org.typelevel" %% "cats-effect" % catsEffectVersion,
  //"org.typelevel" %% "cats-mtl" % catsVersion,
  "org.typelevel" %% "dogs-core" % "0.6.9",

  // Eff
  "org.atnos" %% "eff" % "4.5.0",

  // Monocle
  "com.github.julien-truffaut" %%  "monocle-core"  % monocleVersionCats,
  "com.github.julien-truffaut" %%  "monocle-macro" % monocleVersionCats,
  "com.github.julien-truffaut" %%  "monocle-law"   % monocleVersionCats % "test",

  // Http4s
  "org.http4s" %% "http4s-core" % http4sVersion,
  "org.http4s" %% "http4s-dsl" % http4sVersion,

  // Circe
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,

  // Argonaut
//  "io.argonaut" %% "argonaut" % argonautVersion,
//  "io.argonaut" %% "argonaut-monocle" % argonautVersion,
//  "io.argonaut" %% "argonaut-cats" % argonautVersion, // Cats
//  "io.argonaut" %% "argonaut-scalaz" % argonautVersion,  // Scalaz

  // Doobie scalaz
//  "org.tpolecat" %% "doobie-core" % doobieVersion, // scalaz
//  "org.tpolecat" %% "doobie-h2" % doobieVersion, // scalaz
//  "org.tpolecat" %% "doobie-hikari" % doobieVersion, // scalaz
//  "org.tpolecat" %% "doobie-postgres" % doobieVersion, // scalaz
//  "org.tpolecat" %% "doobie-specs2" % doobieVersion, // scalaz

  // Doobie cats
  "org.tpolecat" %% "doobie-core-cats" % doobieVersion, // cats
  "org.tpolecat" %% "doobie-h2-cats" % doobieVersion, // scalaz
  "org.tpolecat" %% "doobie-hikari-cats" % doobieVersion, // scalaz
  "org.tpolecat" %% "doobie-postgres-cats" % doobieVersion, // scalaz
  "org.tpolecat" %% "doobie-specs2-cats" % doobieVersion, // scalaz

  // Test
  "org.specs2" %% "specs2-core" % specsVersion % "test",
  "org.scalacheck" %% "scalacheck" % scalacheckVersion % "test",

  // https://mvnrepository.com/artifact/org.neo4j/neo4j-common
  "org.neo4j" % "neo4j-common" % "3.3.3",
  "org.neo4j" % "neo4j-cypher" % "3.3.3",
  "org.neo4j.driver" % "neo4j-java-driver" % "1.5.1",
  // TODO: Need to specify driver? Or maybe it's better to use 'core' + the specific, once we know
  "org.neo4j" % "neo4j-ogm" % "3.1.0", //pomOnly()
  "org.neo4j" % "neo4j-ogm-core" % "3.1.0", //pomOnly()
  "org.neo4j" % "neo4j-ogm-bolt-driver" % "3.1.0" //pomOnly()
)

// For macro annotations
addCompilerPlugin("org.scalamacros" %% "paradise" % "2.1.0" cross CrossVersion.full)