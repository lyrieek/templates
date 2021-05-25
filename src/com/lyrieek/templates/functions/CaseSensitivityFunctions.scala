package com.lyrieek.templates.functions

object CaseSensitivityFunctions extends AbstractFunctions {

	override val items = Array[AbstractFunctionItem](
		new AbstractFunctionItem() {
			override val funName = "upper"

			override def exec(str: String): String = str.toUpperCase()

		}, new AbstractFunctionItem() {
			override val funName = "lower"

			override def exec(str: String): String = str.toLowerCase()
			
		})


}
