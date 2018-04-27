package Pers.th

import java.io.File

import Pers.th.expr._

import scala.io.Source
import scala.util.matching.Regex

object Scanner {

//  val regex: Pattern = Pattern compile "<<[a-zA-Z]+(\\d+)?>>"
  val regex: Regex = "\\$\\{[a-zA-Z]+(\\d+)?}".r
  var content: String = ""
  var variable: Set[Expression] = Set()

  def main(args: Array[String]): Unit = {
    val files:Array[File] = new File("resource\\vs-module").listFiles()
    read(files(0).getAbsolutePath)
//    read("resource/r1.template")
    for (elem <- variable) {
      println(elem.value)
    }
  }


  def read(path: String): Unit = {
    val file = Source fromFile path
    for (line <- file.getLines) {
      regex findFirstIn line foreach(item => {
        content += item
        variable += new VariableExpr(item)
      })
    }
    file.close
  }
  
  def exec(fn: Function[Unit,Unit]): Unit = {
    fn.apply()
  }

}
