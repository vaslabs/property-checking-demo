import org.scalacheck.Prop.forAll
import org.scalacheck.{Arbitrary, Gen, Properties}

object FibonacciSpec extends Properties("Fibonacci") {

  implicit val arbitraryFibonacciIndex = Arbitrary(Gen.choose(-100, 100))

  property("product surrounding minus square of middle is (-1)^n") = forAll { (n: Int) =>
    val mid = Fibonacci.find(n)
    val product = Fibonacci.find(n-1)*Fibonacci.find(n+1)
    n == 0 || product - mid*mid == Math.pow(-1, n).toInt
  }

  property("fibonacci numbers on positive indexes are positive") = forAll { (n: Int) =>
    n < 0 || Fibonacci.find(n) >= 0
  }

  property("with index f(n) = f(n+2) - f(n+1)") = forAll { (n: Int) =>
    val `f(n)` = Fibonacci.find(n)
    val `f(n+1)` = Fibonacci.find(n+1)
    val `f(n+2)` = Fibonacci.find(n+2)
    n >= 0 || `f(n)` == `f(n+2)` - `f(n+1)`
  }





}
