package shop

case class Pence(value: Int)

sealed trait Item
case object Apple extends Item
case object Orange extends Item

class ShoppingCart {
    val inventory: Map[Item, Pence] = Map(Apple -> Pence(60), Orange -> Pence(25))
}
