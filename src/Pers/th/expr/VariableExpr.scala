package Pers.th.expr

import scala.util.matching.Regex

class VariableExpr(label: String) extends Expression(label) {

  override val value: String = label.trim

  if (!VariableExpr.regex.pattern.matcher(value).matches())
    throw new Exception("format error")

  override val identifier: String = value.substring(2, value.length - 1)

}

object VariableExpr {

  val regex: Regex = "\\$\\{[a-zA-Z]+(\\d+)?}".r

  /**
    * 根据context 生成多个VariableExpr
    *
    * @param context 原文本
    * @param fun     回调
    */
  def analysis(context: String, fun: Function[VariableExpr, Unit]): Unit = {
    regex findAllIn context foreach { item => fun.apply(new VariableExpr(item)) }
  }

}
