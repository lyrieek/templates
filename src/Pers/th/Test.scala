package Pers.th

import java.io.{File, PrintWriter}
import java.text.SimpleDateFormat
import java.util.Date

object Test {

  final val logFile: File = new File("logger.log")

  final def currentDate:String = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())

  def main(args: Array[String]): Unit = {
    logFile.exists && logFile.delete
    logFile createNewFile
    val writer = new PrintWriter(logFile)
    writer.println(currentDate)
    writer.close()

  }


}
