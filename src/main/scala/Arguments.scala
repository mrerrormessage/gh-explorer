package us.grider.ghexplorer

object Arguments {
  def parse(args: Array[String]): Command = {
    if (args.length < 2)
      Help
    else
      ListPRs
  }
}
