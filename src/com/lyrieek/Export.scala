package com.lyrieek

import java.io.{File, PrintStream}

import com.lyrieek.expr.VariableExpr
import com.lyrieek.util.SourceReader.lines

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
		new Scanner(moduleFolder).files.foreach(file => {
			val currentFile = new File(moduleFolder + file.getName.split(".template")(0) + ".txt")
			currentFile.createNewFile()
			val context = new PrintStream(currentFile)
			lines(file.getAbsolutePath).foreach(line => {
				var currentLine = line
				VariableExpr.scan(currentLine, item => {
					if (param.get(item.value) != null) {
						currentLine = currentLine.replace(item.identifier, param.get(item.value))
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
