package Pers.th.expr

/**
  * 表达式
  * <p>e.g. << label.upper >></p>
  * <p>i.e. (标识符:值)</p>
  *
  * @param item 表达式内容
  */
abstract class Expression(item: String) {

  //标识符
  val identifier: String

  //值
  val value: String

  //打印标识符
  override def toString: String = identifier

  //以表达式内容作为hashCode,而非Expression对象
  override def hashCode: Int = item.hashCode * 0xfff

  //以表达式内容进行比对,而非Expression对象
  override def equals(obj: Any): Boolean = {
    obj match {
      case e: Expression => e.item.equals(this.item)
      case _ => false
    }
  }


}
