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
    "checkout - no offer" - {

        val checkout = cart.checkout(Nil) _
        "Given an empty list then return zero pence" in {
            checkout(Nil) shouldBe Some(Pence(0))
        }

        "Given a list an apple and orange" in {
            checkout(List(Apple, Orange)) shouldBe Some(Pence(85))
        }

        "Given a list of duplicates ensure each item is added seperately" in {
            checkout(List(Apple, Apple)) shouldBe Some(Pence(120))
        }
    }
    "checkout - offer (buy 2 apple get 1 free, by 3 oranges get 2)" - {

        val checkout = cart.checkout(List(Offer(Apple, 2, 1), Offer(Orange, 3, 2))) _

        "Given an empty list then return zero pence" in {
            checkout(Nil) shouldBe Some(Pence(0))
        }

        "Given a list of apples and oranges do no offers if the required amount has not been hit" in {
            checkout(List(Apple, Orange, Orange)) shouldBe Some(Pence(110))
        }

        "Cannot have multiple offers for the same item" in {
            cart.checkout(List(Offer(Orange, 2, 1), Offer(Orange, 3, 2)))(Nil) shouldBe None
        }

    }
} 