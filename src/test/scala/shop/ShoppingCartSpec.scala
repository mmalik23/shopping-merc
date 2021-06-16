package shop

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFreeSpec with Matchers {
    
    val cart = new ShoppingCart

    "inventory" - {
        "contains apples and oranges" in {
            cart.inventory.keys.toList shouldBe List("apple", "orange")
        }

        "price of an apple is 60 pence" in {
            cart.inventory.get("apple") shouldBe Some(Pence(60))
        }

        "price of an orange is 60 pence" in {
            cart.inventory.get("orange") shouldBe Some(Pence(25))
        }
    }
} 