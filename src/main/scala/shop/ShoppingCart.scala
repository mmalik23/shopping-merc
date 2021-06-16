package shop

case class Pence(value: Int) {
    def add(p: Pence) =  this.copy(value + p.value)
}

case class Offer(item: Item, buy: Int, `for`: Int)

sealed trait Item
case object Apple extends Item
case object Orange extends Item

class ShoppingCart {
    val inventory: Map[Item, Pence] = Map(Apple -> Pence(60), Orange -> Pence(25))

    def checkout(offer: List[Offer])(items: List[Item]): Pence = items.flatMap(inventory.get).fold(Pence(0))(_.add(_))
}
