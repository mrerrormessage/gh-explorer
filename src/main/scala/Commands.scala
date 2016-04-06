package us.grider.ghexplorer

sealed trait Command

case object Help extends Command
case object ListPRs extends Command
