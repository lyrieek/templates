package com.lyrieek.expr

import org.junit.Test

class LabelExpr$Test {

    @Test
    void single() {
        println(new LabelExpr(" <<asd>>").value())
        println(new LabelExpr("<<213>> ").value())
    }

}
