package Pers.th.expr

import static Pers.th.expr.VariableExpr.analysis

println(new VariableExpr('${foo}').identifier())
println(new VariableExpr('${bar}').identifier())

analysis('''
    example text: ${foo} ${bar}
''', {
    println(it.identifier())
})
