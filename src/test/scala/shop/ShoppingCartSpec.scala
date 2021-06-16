package shop

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFreeSpec with Matchers {
    
    val cart = new ShoppingCart

    "inventory" - {
        "contains apples and oranges" in {
            cart.inventory.keys.toList shouldBe List(Apple, Orange)
        }

        "price of an apple is 60 pence" in {
            cart.inventory.get(Apple) shouldBe Some(Pence(60))
        }

        "price of an orange is 60 pence" in {
            cart.inventory.get(Orange) shouldBe Some(Pence(25))
        }
    }
} 