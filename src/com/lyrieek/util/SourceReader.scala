package com.lyrieek.util

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

/**
  * 源文件读取
  */
object SourceReader {

  def lines(path: String): List[String] = {
    val file = Source fromFile path
    var lines: ArrayBuffer[String] = ArrayBuffer()
    file.getLines.foreach(lines += _)
    file.close
    lines.toList
  }

}
