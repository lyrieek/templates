package com.lyrieek.templates.exception

case class FileOperationsException(msg: String, t: Throwable) extends RuntimeException(msg, t)