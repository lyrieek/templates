package Pers.th.expr

import scala.util.matching.Regex

class VariableExpr(label: String) extends Expression(label) {

  override val identifier: String = label.trim

  if (!VariableExpr.regex.pattern.matcher(identifier).matches())
    throw new Exception("format error")

  override val value: String = identifier.substring(2, identifier.length - 1)

}

object VariableExpr {

  val regex: Regex = "\\$\\{[a-zA-Z]+(\\d+)?}".r

  /**
    * 根据context 生成多个VariableExpr
    *
    * @param context 原文本
    * @param fun     回调
    */
  def >>(context: String, fun: Function[VariableExpr, Unit]): Unit = {
    regex findAllIn context foreach { item => fun.apply(new VariableExpr(item)) }
  }

}
