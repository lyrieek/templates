package Pers.th

import scala.io.Source

object Scanner {

  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("resource/r1.template")
    for (line <- file.getLines) {
      println(line match {
        case "<<black>>" =>
          println("template"+line)
        case _ => line
      })
      line.matches("<<[a-zA-Z]+>>")
    }
    file.close
  }

}
