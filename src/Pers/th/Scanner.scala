package Pers.th

import java.io.File

import Pers.th.expr._

import scala.io.Source

object Scanner {

  val files: Array[File] = new File("resource\\vs-module").listFiles()

  def main(args: Array[String]): Unit = {
    var variable: Set[Expression] = Set()
    for (file <- files) {
      variable ++= read(file.getAbsolutePath)
    }
    for (elem <- variable)
      println(elem.value)
  }
  def read(path: String): Set[Expression] = {
    var variable: Set[Expression] = Set()
    val file = Source fromFile path

    for (line <- file.getLines) {
      VariableExpr.analysis(line, item => variable += item)
    }
    file.close
    variable
  }

}
