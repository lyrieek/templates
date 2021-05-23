package com.lyrieek

import java.io.{File, FileReader, FileWriter, Writer}
import java.util.Map.Entry
import java.util.Properties

class Parameter {

	val prop: Properties = new Properties()

	def entrySet: java.util.Iterator[Entry[AnyRef, AnyRef]] = prop.entrySet().iterator()

	def get(key: String): String = prop.getProperty(key)

	def set(key: String, value: String): AnyRef = prop.setProperty(key, value)

	def save(writer: Writer): Unit = prop.store(writer, "com.lyrieek.Parameter output")

	def save(path: File): Unit = {
		val writer: FileWriter = new FileWriter(path)
		save(writer)
		writer.flush()
		writer.close()
	}

	def load(path: String): Unit = prop.load(new FileReader(path))

	def load(file: File): Unit = prop.load(new FileReader(file))

	def clear(): Unit = prop.clear()

	def has(any: Any): Boolean = prop.containsKey(any)

}
