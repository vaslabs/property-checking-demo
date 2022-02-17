import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

object MinMaxSpec extends Properties("MinMax"){

  property("identity") = forAll { (a: Int) =>
    Math.max(a, a) == a
    Math.min(a, a) == a
  }

  property("associative") = forAll { (a: Int, b: Int, c: Int) =>
    Math.max(Math.max(a, b), c) == Math.max(a, Math.max(b, c))
  }

  property("commutative") = forAll { (a: Int, b: Int) =>
    Math.max(a, b) == Math.max(b, a)
  }

  property("idempotency") = forAll { (a: Int, b: Int) =>
    Math.max(Math.max(a, b), b) == Math.max(a, b)
  }

  property("transitivity") = forAll { (a: Int, b: Int, c: Int) =>
     //a<=b<=c
    ((b isMaxOf a) and (c isMaxOf b) `then` (c isMaxOf a)) ||
    //a<=c<=b
      ((c isMaxOf a) and (b isMaxOf c) `then` (b isMaxOf c)) ||
    //b<=a<=c
      ((a isMaxOf b) and (c isMaxOf a) `then` (c isMaxOf b)) ||
    //b<=c<=a
      ((c isMaxOf b) and (a isMaxOf c) `then` (a isMaxOf b)) ||
    //c<=a<=b
      ((a isMaxOf c) and (b isMaxOf a) `then` (b isMaxOf c)) ||
    //c<=b<=a
      ((b isMaxOf c) and (a isMaxOf b) `then` (a isMaxOf c))
  }

  implicit final class BooleanOps(value: Boolean) {
    def `then`(pred: Boolean): Boolean = value && pred
    def and (pred: Boolean): Boolean = value && pred
  }

  implicit final class IntOps(value: Int) {
    def isMaxOf(b: Int): Boolean =
      Math.max(value, b)  == value
  }

}
