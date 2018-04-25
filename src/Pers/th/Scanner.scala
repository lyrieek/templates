package Pers.th

import scala.io.Source

object Scanner {

  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("resource/r1.template")
    for (line <- file.getLines) {
      println(line)
    }
    file.close

  }

}
