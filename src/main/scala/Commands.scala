package us.grider.ghexplorer

sealed trait Command

case object Help extends Command
case class HelpSpecific(topic: String) extends Command
case class ListPRs(repo: String) extends Command
