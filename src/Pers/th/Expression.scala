package Pers.th

class Expression(var label: String) {

  label = label.trim

  if (!label.startsWith("<<") || !label.endsWith(">>"))
    throw new Exception("format error")

  def identifier: String = {
    label.substring(2, label.length - 2)
  }

  override def toString: String = {
    identifier
  }

  override def hashCode: Int = {
    label.hashCode * 0xfff
  }

  override def equals(obj : Any): Boolean = {
    obj match{
      case e:Expression => e.label.equals(this.label)
      case _ => false
    }
  }


}
