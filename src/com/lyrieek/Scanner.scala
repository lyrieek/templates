package com.lyrieek

import java.io.File

import com.lyrieek.expr.{Expression, VariableExpr}
import com.lyrieek.util.SourceReader.lines

class Scanner(moduleFolder: String) {

	val files: Array[File] = new File(moduleFolder).listFiles().filter(_.getName.endsWith(".template"))

	var variable: Set[Expression] = Set()

	def scan(): Parameter = {
		//scanner variable
		files.foreach(file => read(file.getAbsolutePath))

		//fill variable
		val param: Parameter = new Parameter()
		println(variable.size)
		variable.foreach(elem => param.set(elem.value, ""))
		param
	}

	def read(path: String): Unit = {
		lines(path).foreach(line => {
			//analysis file context
			VariableExpr.scan(line, variable += _)
		})
	}

}
