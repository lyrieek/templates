
var temp: Unit = (0 to 10).foreach((i: Int) => {
  println(i)
})

temp = 0.to(10).foreach(i => println(i))

temp = 0 to 10 map { i => println(i);i}

print(temp)

