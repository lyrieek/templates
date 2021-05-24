package com.lyrieek.templates

import java.io.File

import com.lyrieek.templates.util.FileOperations

object Bootstrap extends App {

	val moduleFolder = "./resources/templates-test/"

	val paramFile = new File(moduleFolder + "parameter.properties")
	if (FileOperations.need(paramFile)) {
		new Scanner(moduleFolder).scan().save(paramFile)
		sys.exit()
	}

	println("parameter file:" + paramFile)

	val export = new Export(moduleFolder)
	export.param.load(paramFile)
	export.run()

}
