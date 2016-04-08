package us.grider.ghexplorer

import org.scalatest.FunSpec

import scala.io.Source

import scalaj.http.HttpResponse

class InterpreterSpec extends FunSpec {
  def errorResponse = HttpResponse[String]("""{"message": "bad list PR request"}""", 400, Map())

  lazy val PRResponseString = Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("PRListSuccess.json")).mkString

  def listPRResponse = HttpResponse[String](PRResponseString, 200, Map())
  describe("listing a PR") {
    it("should return an error when the response is not a 200") {
      try {
        Interpret(ListPRs("foo/bar"), Function.const(errorResponse))
        fail("expected exception to be raised on error")
      } catch {
        case ex: Exception =>
          assert(ex.getMessage == "bad list PR request")
      }
    }
    it("should return a list of string maps when the response is successful") {
      val prList = Interpret(ListPRs("foo/bar"), Function.const(listPRResponse))
      assert(prList.length == 1)
      assert(prList.head == 1)
    }
  }
}
