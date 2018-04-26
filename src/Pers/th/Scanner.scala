package Pers.th

import java.util.regex.Pattern

import scala.io.Source

object Scanner {

  val regex: Pattern = Pattern compile "<<[a-zA-Z]+(\\d+)?>>"
  var content: String = ""
  var variable: Set[Expression] = Set()

  def main(args: Array[String]): Unit = {
    read("resource/r1.template")
    for (elem <- variable) {
      println(elem.identifier)
    }
  }

  def read(path: String): Unit = {
    val file = Source fromFile path
    for (line <- file.getLines) {
      val item = regex matcher line
      while (item.find) {
        content += item.group
        variable += new Expression(item.group())
      }
    }
    file.close
  }
  
  def exec(fn: Function[Unit,Unit]): Unit = {
    fn.apply()
  }

}
