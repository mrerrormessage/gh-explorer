package us.grider.ghexplorer

import org.scalatest.FunSpec

class ArgumentsSpec extends FunSpec {
  describe("parsing arguments") {
    it("should print help when no arguments provided") {
      assert(Arguments.parse(Array()) == Help)
    }
    it("should print help when -h argument provided") {
      assert(Arguments.parse(Array("-h")) == Help)
    }
    it("should list PRs when 'prs list' are the arguments") {
      assert(Arguments.parse(Array("prs", "list", "mrerrormessage/gh-explorer")) == ListPRs("mrerrormessage/gh-explorer"))
    }
    it("should print help for 'prs list' when no repo is provided") {
      assert(Arguments.parse(Array("prs", "list")) == HelpSpecific("prs"))
    }
  }
}
