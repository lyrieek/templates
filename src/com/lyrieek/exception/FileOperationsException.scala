package com.lyrieek.exception

case class FileOperationsException(msg: String, t: Throwable) extends RuntimeException(msg, t)