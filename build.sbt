organization := "us.grider"                                                                                                                                                                
                                                                                                                                                                                           
name := "gh-explorer"                                                                                                                                                                      
                                                                                                                                                                                           
scalaVersion := "2.11.8"                                                                                                                                                                   
                                                                                                                                                                                           
scalacOptions ++=                                                                                                                                                                          
  Seq("-deprecation", "-unchecked", "-feature", "-Xcheckinit", "-encoding", "us-ascii", "-Xlint", "-Xfatal-warnings")

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
