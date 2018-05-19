package pers.th

import java.io.File
import java.util

import pers.th.expr._

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Scanner {

  val files: Array[File] = new File("resources/vs-module").listFiles()

  var variable: Set[Expression] = Set()

  def main(args: Array[String]): Unit = {

    //scanner variable
    files.foreach(file => read(file.getAbsolutePath))

    val param: Parameter = new Parameter()
    //output variable
    println(variable.size)
    variable.foreach(elem => param.set(elem.value, elem.value))

    param.save("resources/parameter.properties")
  }

  def lines(path: String): List[String] = {
    val file = Source fromFile path
    var lines: ArrayBuffer[String] = ArrayBuffer()
    file.getLines.foreach(lines += _)
    file.close
    lines.toList
  }

  def read(path: String): Unit = {
    lines(path).foreach(line => {
      //analysis file context
      VariableExpr.>>(line, variable += _)
    })
  }

}
