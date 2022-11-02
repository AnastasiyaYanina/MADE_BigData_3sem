//println("Hello world")
val x = 24534463464L
def x(g: Int): Int = g * g
val simpleList = Seq(1,2,3,4)
simpleList.map(row => x(row))
//val anotherList = simpleList
//  .map(el => el*el)
//  .map(el => el*3)
//  .reduce(_+_)
val anotherList = simpleList
  .map(el => {
    val strange = "1223"
    el * el
  })
  .map(_.toString)
case class Musician(name: String,
                    role: String,
                    age: Byte)
val till = Musician("Till", "Singer", 55)
val rndDrummer = Musician("Bryan", "Drummer", 35)
//till.age = 12
val arrMusician = Array[Musician](till, rndDrummer)

arrMusician.map(_.name)