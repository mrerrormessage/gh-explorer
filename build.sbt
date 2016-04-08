organization := "us.grider"                                                                                                                                                                
                                                                                                                                                                                           
name := "gh-explorer"                                                                                                                                                                      
                                                                                                                                                                                           
scalaVersion := "2.11.8"                                                                                                                                                                   
                                                                                                                                                                                           
scalacOptions ++=                                                                                                                                                                          
  Seq("-deprecation", "-unchecked", "-feature", "-Xcheckinit", "-encoding", "us-ascii", "-Xlint", "-Xfatal-warnings")

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"

libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.3.0"

libraryDependencies += "org.json4s" %% "json4s-native" % "3.3.0"

