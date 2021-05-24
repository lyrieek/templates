package com.lyrieek.templates.util

import java.io.File

import com.lyrieek.templates.exception.FileOperationsException

object FileOperations {

	def need(file: File): Boolean = {
		if (file.exists()) {
			return false
		}
		try {
			file.createNewFile()
		} catch {
			case ex: Exception => throw FileOperationsException("Failed to create new file", ex)
		}
		true
	}

}
