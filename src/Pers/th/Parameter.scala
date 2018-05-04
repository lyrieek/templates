package Pers.th

import java.io.FileReader
import java.util.Properties

/**
  * Created by Tianhao on 2018-05-05.
  */
object Parameter {

  def load(path:String)={
    val prop = new Properties()
    prop.load(new FileReader(path))
    
  }

}
