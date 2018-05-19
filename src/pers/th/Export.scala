package pers.th

import java.io.{File, PrintStream}
import java.util
import java.util.Map

import pers.th.Scanner.files
import pers.th.expr.VariableExpr

import scala.io.Source

object Export {

  val param: Parameter = new Parameter()
  param.load("resources/parameter.properties")
  val set: util.Iterator[util.Map.Entry[AnyRef, AnyRef]] = param.entrySet

  val output = new File("resources/output")
  if (output.exists()) {
    val listFile = output.listFiles()
    listFile.isEmpty && output.delete
    if (listFile.nonEmpty) {
      listFile.foreach(fileItem => fileItem.delete())
    }
  }
  output.mkdir()

  def main(args: Array[String]): Unit = {

    Scanner.files.foreach(file => {
      val currentFile = new File(output.getAbsolutePath + "/" + file.getName.split(".template")(0))
      currentFile.createNewFile()
      val context = new PrintStream(currentFile)
      Scanner.lines(file.getAbsolutePath).foreach(line => {
        var currentLine = line
        VariableExpr.>>(currentLine, item => {
          currentLine = currentLine.replace(item.identifier, param.get(item.value))
        })
        context.println(currentLine)
        context.flush()
      })
      context.close()
    })

  }

}
