package Pers.th.expr

class LabelExpr(label: String) extends Expression(label) {

  override val value: String = label.trim

  if (!value.startsWith("<<") || !value.endsWith(">>"))
    throw new Exception("format error")

  override val identifier: String = value.substring(2, value.length - 2)

}

