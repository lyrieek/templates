package com.lyrieek

import java.io.File

import com.lyrieek.util.FileOperations

object Bootstrap extends App {

	val moduleFolder = "./resources/simpleTest"

	val paramFile = new File(moduleFolder + "/parameter.properties")
	if (FileOperations.need(paramFile)) {
		new Scanner(moduleFolder).scan().save(moduleFolder + "/parameter.properties")
		sys.exit()
	}

	println("parameter file:" + paramFile)

}