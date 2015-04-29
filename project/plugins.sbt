// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository 
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// scalariform for the glorius benefit of auto-indent rules
addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.3.0")
