package com.lyrieek.templates

import java.io.{File, PrintStream}

import com.lyrieek.templates.expr.VariableExpr
import com.lyrieek.templates.functions.FunctionInvoker
import com.lyrieek.templates.util.SourceReader.lines

/**
  * 导出工具
  */
class Export(moduleFolder: String) {

	val param: Parameter = new Parameter()

	//	val output: File = {
	//		val output = new File("resources/output")
	//		if (output.exists()) {
	//			val listFile = output.listFiles()
	//			listFile.isEmpty && output.delete
	//			if (listFile.nonEmpty) {
	//				listFile.foreach(fileItem => fileItem.delete())
	//			}
	//		}
	//		output.mkdir()
	//		output
	//	}

	def run(): Unit = {
		val fi = new FunctionInvoker()
		new Scanner(moduleFolder).files.foreach(file => {
			val ext = param match {
				case builtIn if builtIn.has("file.builtIn.ext") && file.getName.matches(param.get("file.builtIn.ext")) => ""
				case common if common.has("file.common.ext") => param.get("file.common.ext")
				case _ => TemplateConstant.FILE_COMMON_EXT_DEFAULT
			}
			//			val ext = {
			//				if (param.has("file.builtIn.ext") && file.getName.matches(param.get("file.builtIn.ext"))) ""
			//				else if (param.has("file.common.ext")) param.get("file.common.ext")
			//				else TemplateConstant.FILE_COMMON_EXT_DEFAULT
			//			}
			val currentFile = new File(moduleFolder, param.get("file.common.prefix") + file.getName.split("\\.")(0) + ext)
			currentFile.createNewFile()
			val context = new PrintStream(currentFile)
			lines(file.getAbsolutePath).foreach(line => {
				var currentLine = line
				VariableExpr.scan(currentLine, item => {
					if (param.get(item.value) != null) {
						currentLine = currentLine.replace(item.identifier, {
							if (item.functions.isEmpty)
								param.get(item.value)
							else
								fi.exec(item.functions, param.get(item.value))
						})
					}
					param.get(item.value)
				})
				context.println(currentLine)
				context.flush()
			})
			context.close()
		})

	}

}
