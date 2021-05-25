package com.lyrieek.templates.functions


class FunctionInvoker extends AbstractFunctions {

	val items: Array[AbstractFunctionItem] = CaseSensitivityFunctions.items ++ NomenclatureFunctions.items

	def exec(funName: String, value: String): String = {
		items.find(item => funName.equals(item.funName)).get.exec(value)
	}

}
