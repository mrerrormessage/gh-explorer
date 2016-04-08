package us.grider.ghexplorer

import scalaj.http.HttpResponse

import org.json4s.{ JArray, JField, JInt, JObject, JString }
import org.json4s.native.JsonMethods.parse

object Interpret {
  def apply(command: Command, http: Command => HttpResponse[String]): List[Int] = {
    command match {
      case ListPRs(repo) =>
        val res = http(command)
        val parsedBody = parse(res.body)
        if (res.code >= 400) {
          val errorMessage = 
            (parsedBody \ "message") match {
              case JString(err) => err
              case _ => "Error while attempting to list PRs"
            }
          throw new Exception(errorMessage)
        } else {
          parsedBody match {
            case JArray(vals) => vals.collect {
              case obj: JObject => obj \ "id"
            }.collect {
              case JInt(i) => i.toInt
            }
            case _ => List()
          }
        }

      case _ => List()
    }
  }
}
