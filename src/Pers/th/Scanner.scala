package Pers.th

import java.util.regex.Pattern

import scala.io.Source

object Scanner {

  def main(args: Array[String]): Unit = {
    val file = Source fromFile "resource/r1.template"
    val regex = Pattern compile "<<[a-zA-Z]+>>"
    for (line <- file.getLines) {
//      line match {
//        case "<<black>>" =>
//        case _ =>
//      }
      val item = regex matcher line
      while (item.find){
        println(item group)
      }
    }
    file.close
  }

}
