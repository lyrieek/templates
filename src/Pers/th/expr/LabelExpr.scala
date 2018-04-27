package Pers.th.expr

class LabelExpr(var label: String) extends Expression(label) {

  item = item.trim

  if (!item.startsWith("<<") || !item.endsWith(">>"))
    throw new Exception("format error")

  override val identifier: String = {
    item.substring(2, item.length - 2)
  }

  override val value: String = identifier

}

