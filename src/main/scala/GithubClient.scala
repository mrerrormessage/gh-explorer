package us.grider.ghexplorer

import scalaj.http.{ Http, HttpResponse }

object GithubClient {
  val BaseURL = "https://api.github.com"

  def runCommand(cmd: Command): HttpResponse[String] = {
    val path = cmd match {
      case ListPRs(repo) => s"/repos/$repo/pulls"
      case _ => throw new Exception("Github client doesn't know how to request " + cmd)
    }

    Http(BaseURL + path).asString
  }
}
