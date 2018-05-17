package pers.th.zip

import java.io.{File, FileOutputStream}
import java.util.zip.ZipFile

object Compress {

  def unZipFile(zipFile: File, descDir: String): Boolean = {
    var flag = true
    try {
      val pathFile: File = new File(descDir)
      if (!pathFile.exists) {
        pathFile.mkdirs
      }
      val zip = new ZipFile(zipFile)
      val entries = zip.entries
      while (entries.hasMoreElements) {
        val entry = entries.nextElement
        val zipEntryName = entry.getName
        val in = zip.getInputStream(entry)
        val outPath = (descDir + zipEntryName).replaceAll("\\*", "/")
        //判断路径是否存在,不存在则创建文件路径
        val file = new File(outPath.substring(0, outPath.lastIndexOf('/')))
        !file.exists && file.mkdirs
        //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
        if (!new File(outPath).isDirectory) {
          //输出文件路径信息
          println(outPath)
          val out = new FileOutputStream(outPath)
          //val writer = new PrintWriter(new File(outPath))
          val buf1 = Array[Byte]()
          while (in.read(buf1) > 0) {
            in.read
            out.write(buf1)
          }
          // out.close
        }
        in.close()
      }
    } catch {
      case _: Exception =>
        flag = false
    }
    flag
  }
}
