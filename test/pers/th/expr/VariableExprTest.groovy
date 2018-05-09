package pers.th.expr

println(new VariableExpr('${foo}').identifier())
println(new VariableExpr('${bar}').identifier())

VariableExpr.$greater$greater('''
    example text: ${foo} ${bar}
''', {
    println(it.identifier())
})
