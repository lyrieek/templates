package Pers.th.expr

println(new VariableExpr('${foo}').identifier())
println(new VariableExpr('${bar}').identifier())
println(new VariableExpr('${bar} ${bar}').identifier())