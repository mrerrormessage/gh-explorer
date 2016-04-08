package us.grider.ghexplorer

object Arguments {
  def parse(args: Array[String]): Command = {
    if (args.isEmpty || args.contains("-h"))
      Help
    args.toList match {
      case "prs" :: "list" :: repo :: Nil => ListPRs(repo)
      case "prs" :: _ => HelpSpecific("prs")
      case _ => Help
    }
  }
}
