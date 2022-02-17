import org.scalacheck.Properties
import CollectionOps._
import org.scalacheck.Prop.forAll

import scala.util.Random

object SortedSpec extends Properties("Sorting") {

  property("consistency") = forAll { (a: List[Int]) =>
    sort(shuffle(a)) == sort(a)
  }

  property("reverse") = forAll { (a: List[Int]) =>
    sort(a) == sortDesc(a).reverse
  }

  property("idempotency") = forAll { (a: List[Int]) =>
    sort(sort(a)) == sort(a)
  }

  private def shuffle[A](list: List[A]): List[A] =
    new Random().shuffle(list)

}
