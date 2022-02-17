import scala.annotation.tailrec

object Fibonacci {

  def find(n: Int): BigInt = findRec(n)

  def findRec(n: Int): BigInt = {
    @tailrec
    def fib(n: Int, previousValue: BigInt, currentValue: BigInt): BigInt = {
      if (n == 0)
        currentValue
      else
        fib(n-1, currentValue, currentValue + previousValue)
    }
    val index = Math.abs(n)
    if (n >= 0)
      fib(index, 1, 0)
    else
      BigInt(-1).pow(index+1)*fib(index, 1, 0)
  }
}
