package pers.th

import pers.th.Scanner.files

import scala.io.Source

object Export {

  def main(args: Array[String]): Unit = {
    val param: Parameter = new Parameter()
    param.load("resources/parameter.properties")
    val set = param.entrySet
    while (set.hasNext) {
      println(set.next())
    }

    //    for (path <- files) {
    //      val file = Source fromFile path
    //      for (line <- file.getLines) {
    //        println(line)
    //      }
    //    }
  }

}
