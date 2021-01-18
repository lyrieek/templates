package com.lyrieek

import java.io.File

import com.lyrieek.expr.{Expression, VariableExpr}
import com.lyrieek.expr._
import com.lyrieek.util.SourceReader.lines

/**
  * 扫描器
  */
object Scanner {

	val files: Array[File] = new File("resources/vs-module").listFiles()

	var variable: Set[Expression] = Set()

	def main(args: Array[String]): Unit = {

		//scanner variable
		files.foreach(file => read(file.getAbsolutePath))

		val param: Parameter = new Parameter()
		//output variable
		println(variable.size)
		variable.foreach(elem => param.set(elem.value, elem.value))

		param.save("resources/parameter.properties")
	}

	def read(path: String): Unit = {
		lines(path).foreach(line => {
			//analysis file context
			VariableExpr.>>>(line, variable += _)
		})
	}

}
