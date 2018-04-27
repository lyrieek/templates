package Pers.th

import Pers.th.expr.VariableExpr

println(new VariableExpr(" \${foo}").identifier())
println(new VariableExpr("\${bar} ").identifier())
