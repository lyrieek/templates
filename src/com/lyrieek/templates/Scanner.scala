package com.lyrieek.templates

import java.io.File

import com.lyrieek.templates.expr.{Expression, VariableExpr}
import com.lyrieek.templates.util.SourceReader.lines

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

		param.set("file.common.prefix", "$" + variable.head.value)
		param.set("file.common.ext", TemplateConstant.FILE_COMMON_EXT_DEFAULT)
//		param.set("file.builtIn.ext", "")

		param
	}

	def read(path: String): Unit = {
		lines(path).foreach(line => {
			//analysis file context
			VariableExpr.scan(line, variable += _)
		})
	}

}
