package pers.th

import pers.th.Scanner.files

import scala.io.Source

object Export {

  def main(args: Array[String]): Unit = {
    Parameter.load("resources/param-setting.properties")
    for (path <- files) {
      val file = Source fromFile path
      for (line <- file.getLines) {
        println(line)
      }
    }
  }

}
