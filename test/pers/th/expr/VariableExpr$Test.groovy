package pers.th.expr

import org.junit.Test
import scala.Function1
import scala.runtime.BoxedUnit

class VariableExpr$Test {

    @Test
    void single() {
        println(new VariableExpr('${foo}').value())
        println(new VariableExpr('${bar}').value())
        println(new VariableExpr('${bar}').value())
    }

    @Test
    void batch() {
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
