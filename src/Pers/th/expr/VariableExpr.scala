package Pers.th.expr

class VariableExpr(var label: String) extends Expression(label) {

  item = item.trim

  if (!item.startsWith("${") || !item.endsWith("}"))
    throw new Exception("format error")

  override val identifier: String = {
    item.substring(2, item.length - 1)
  }

  override val value: String = identifier

}
