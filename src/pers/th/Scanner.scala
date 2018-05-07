package pers.th

import java.io.File

import pers.th.expr._

import scala.io.Source

object Scanner {

  val files: Array[File] = new File("resource\\vs-module").listFiles()

  def main(args: Array[String]): Unit = {
    var variable: Set[Expression] = Set()

    //scanner variable
    for (file <- files)
      variable ++= read(file.getAbsolutePath)

    //output variable
    for (elem <- variable)
      println(s"${elem.value}:")
  }

  def read(path: String): Set[Expression] = {
    var variable: Set[Expression] = Set()
    val file = Source fromFile path
    for (line <- file.getLines) {
      //analysis file context
      VariableExpr.>>(line, item => variable += item)
    }
    file.close
    variable
  }

}
