package shop

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFreeSpec with Matchers {
    
    val cart = new ShoppingCart

    "inventory" - {
        "contains apples and oranges" in {
            cart.inventory shouldBe Set("apple", "orange")
        }
    }
}