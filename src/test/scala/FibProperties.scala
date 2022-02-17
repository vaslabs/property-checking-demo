import org.scalacheck.{Arbitrary, Gen, Properties}
import org.scalacheck.Prop.forAll

object FibProperties extends Properties("Fibonacci") {

  implicit val arbitraryFibonacciIndex = Arbitrary(Gen.choose(-100, 100))

  //interestingly doesn't apply for negative fibonacci sequence
  property("product of surrounding minus square of middle is (-1)^n") = forAll { (n: Int) =>
    val mid = Fibonacci.find(n)
    val product = Fibonacci.find(n-1)*Fibonacci.find(n+1)
    val midSquare = mid*mid
    println(s"$product - $midSquare = (-1)^$n")
    n == 0 || product - midSquare == Math.pow(-1, n+1).toInt
  }

  property("Fibonacci with negative index is f(n+2) - f(n+1)") = forAll { (n: Int) =>
    val `f(n)` = Fibonacci.find(n)
    val `f(n+1)` = Fibonacci.find(n+1)
    val `f(n+2)` = Fibonacci.find(n+2)
    println(s"$n: ${`f(n)`} == ${`f(n+2)`} - ${`f(n+1)`}")
    n >= 0 || `f(n)` == `f(n+2)` - `f(n+1)`
  }



}
