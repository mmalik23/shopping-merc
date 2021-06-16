package shop

case class Pence(value: Int)

sealed trait Item
case object Apple extends Item
case object Orange extends Item

class ShoppingCart {
    val inventory: Map[Item, Pence] = Map(Apple -> Pence(60), Orange -> Pence(25))

    def checkout(items: List[Item]): Pence = Pence(items.flatMap(inventory.get).map(_.value).fold(0)(_ + _))
}
