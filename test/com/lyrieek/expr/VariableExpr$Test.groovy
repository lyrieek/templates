package com.lyrieek.expr

import org.junit.Test
import scala.Function1
import scala.runtime.BoxedUnit

/**
 * 测试解析变量的功能，寻找与提取各类文本中的变量
 */
class VariableExpr$Test {

    @Test
    void testSingleValParse() {
        println(new VariableExpr('${foo}').value())
        println(new VariableExpr('${bar}').value())
        println(new VariableExpr('${bar}').value())
    }

    @Test
    void testBatchScanAndParse() {
        VariableExpr.$greater$greater$greater('''
            example text: ${foo} ok
            enter
            ${bar}
        ''', {
            VariableExpr item ->
                println item.identifier() + ":" + item.value()
        } as Function1<VariableExpr, BoxedUnit>)
    }

}
