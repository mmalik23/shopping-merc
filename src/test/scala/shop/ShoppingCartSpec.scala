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
    "checkout" - {
        "Given an empty list then return zero pence" in {
            cart.checkout(Nil) shouldBe Pence(0)
        }

        "Given a list an apple and orange" in {
            cart.checkout(List(Apple, Orange)) shouldBe Pence(85)
        }

        "Given a list of duplicates ensure each item is added seperately" in {
            cart.checkout(List(Apple, Apple)) shouldBe Pence(120)
        }
    }
} 