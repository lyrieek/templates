package com.lyrieek.templates.expr

import org.junit.Test

/**
 * 测试提取标签
 */
class LabelExpr$Test {

    @Test
    void single() {
        println(new LabelExpr(" <<asd>>").value())
        println(new LabelExpr("<<213>> ").value())
    }

}
