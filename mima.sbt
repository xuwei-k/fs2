mimaDefaultSettings

resolvers += "Scalaz Bintray Repo" at "https://dl.bintray.com/scalaz/releases"

com.typesafe.tools.mima.plugin.MimaKeys.previousArtifact := Some(organization.value %% name.value % "0.7a")
