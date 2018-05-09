package pers.th

import java.io.{FileReader, Writer}
import java.util.Properties

object Parameter {

  val prop = new Properties()

  def get(key: String): String = prop.getProperty(key)

  def set(key: String, value: String): AnyRef = prop.setProperty(key, value)

  def save(writer: Writer): Unit = prop.store(writer, "pers.th.Parameter output")

  def load(path: String): Unit = prop.load(new FileReader(path))

  def clear(): Unit = prop.clear()

  def has(any: Any): Boolean = prop.containsKey(any)

}
