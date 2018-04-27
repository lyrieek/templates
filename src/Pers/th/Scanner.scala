package Pers.th

import java.io.File

import Pers.th.expr._

import scala.io.Source
import scala.util.matching.Regex

object Scanner {

  //  val regex: Pattern = Pattern compile "<<[a-zA-Z]+(\\d+)?>>"
  val regex: Regex = "\\$\\{[a-zA-Z]+(\\d+)?}".r
  var variable: Set[Expression] = Set()

  val files: Array[File] = new File("resource\\vs-module").listFiles()

  def main(args: Array[String]): Unit = {
    for (file <- files) {
      read(file.getAbsolutePath)
    }
    //    read("resource/r1.template")
    for (elem <- variable)
      println(elem.value)
  }

  def read(path: String): Unit = {
    val file = Source fromFile path
    for (line <- file.getLines)
      regex findAllIn line foreach
        (item => variable += new VariableExpr(item))
    file.close
  }

  //  exec(_ => {
  //    println(1)
  //  })
  //  def exec(fn: Function[Unit,Unit]): Unit = {
  //    fn.apply()
  //  }

}
