package shop

case class Pence(value: Int)
class ShoppingCart {
    val inventory: Map[String, Pence] = Map("apple" -> Pence(60), "orange" -> Pence(25))
}
