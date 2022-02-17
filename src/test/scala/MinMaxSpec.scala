import org.scalacheck.Properties

object MinMaxSpec extends Properties("MinMax"){

  implicit final class BooleanOps(value: Boolean) {
    def `then`(pred: Boolean): Boolean = value && pred
    def and (pred: Boolean): Boolean = value && pred
  }

  implicit final class IntOps(value: Int) {
    def isMaxOf(b: Int): Boolean =
      Math.max(value, b)  == value
  }

}
