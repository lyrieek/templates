package pers.th

import java.io.File
import java.util

import pers.th.expr._

import scala.io.Source

object Scanner {

  val files: Array[File] = new File("resources\\vs-module").listFiles()

  var variable: Set[Expression] = Set()

  def main(args: Array[String]): Unit = {

    //scanner variable
    files.foreach(file => read(file.getAbsolutePath))

    val param: Parameter = new Parameter()
    //output variable
    variable.foreach(elem => param.set(elem.value, elem.value))

    param.save("resources/parameter.properties")
  }

  def lines(path: String): List[String] = {
    val file = Source fromFile path
    var lines: List[String] = List()
    file.getLines.foreach(line => lines + (line))
//    file.getLines.foreach(line => lines ++ line)
    file.close
    lines
  }

  def read(path: String): Unit = {
    //analysis file context
    lines(path).foreach(line => {
      println(line)
      VariableExpr.>>(line, item => variable + item)
    })
  }

}
