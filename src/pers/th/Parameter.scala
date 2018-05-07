package pers.th

import java.io.{FileReader, FileWriter, Writer}
import java.util.Properties

class Parameter {

  val prop = new Properties()

  def get(key: String): String = prop.getProperty(key)

  def set(key: String, value: String): AnyRef = prop.setProperty(key, value)

  def set(key: String): AnyRef = prop.setProperty(key, "")

  def save(writer: Writer): Unit = prop.store(writer, "Pers.th.Parameter output")

  def save(path: String): Unit = {
    val writer: FileWriter = new FileWriter(path)
    save(writer)
    writer.flush()
    writer.close()
  }

  def load(path: String): Unit = prop.load(new FileReader(path))

  def clear(): Unit = prop.clear()

  def has(any: Any): Boolean = prop.containsKey(any)

}
