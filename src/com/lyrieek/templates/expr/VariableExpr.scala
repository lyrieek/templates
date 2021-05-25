package com.lyrieek.templates.expr

import com.lyrieek.templates.exception.ParseException

import scala.util.matching.Regex

class VariableExpr(label: String) extends Expression(label) {

	override val identifier: String = label.trim

	if (!VariableExpr.regex.pattern.matcher(identifier).matches())
		throw ParseException("VariableExpr doesn't match")

	override val functions: String = {
		if (identifier.contains("."))
			identifier.substring(identifier.indexOf(".") + 1, identifier.length - 1)
		else ""
	}

	override val value: String = identifier.substring(2, identifier.length - 1 - (if (functions.length > 0) functions.length + 1 else 0))

}

object VariableExpr {

	val regex: Regex = "\\\\\\{[a-zA-Z]+(\\d+)?(\\.[a-zA-Z]+(\\d+)?)?}".r

	/**
	  * Scan the text to get all the variables
	  *
	  * @param context content
	  * @param fun     callback
	  */
	def scan(context: String, fun: Function[VariableExpr, Unit]): Unit = {
		regex findAllIn context foreach (item => {
			fun.apply(new VariableExpr(item))
		})
	}

}
