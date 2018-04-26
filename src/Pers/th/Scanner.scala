package Pers.th

import java.util.regex.Pattern

import scala.io.Source

object Scanner {

  def main(args: Array[String]): Unit = {
    var variable: Set[Expression] = Set()
    val file = Source fromFile "resource/r1.template"
    val regex = Pattern compile "<<[a-zA-Z]+(\\d+)?>>"
    for (line <- file.getLines) {
      val item = regex matcher line
      while (item.find){
        variable += new Expression(item.group())
      }
    }
    file.close
    for (elem <- variable) {
      println(elem.identifier)
    }
  }

  def item = {

  }
  

}
