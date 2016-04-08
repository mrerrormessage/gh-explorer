package us.grider.ghexplorer

object CommandLine extends App {
  val command = Arguments.parse(args)
  command match {
    case Help  =>
      Console.println("-h: print this message and exit")
      Console.println("prs list: list prs")
    case HelpSpecific(topic) =>
      Console.println("prs list [REPO]: list prs for repo")
    case l@ListPRs(repository) =>
      val prIds = Interpret(l, GithubClient.runCommand _)
      Console.println("PRs: " + prIds.mkString(", "))
  }
}
