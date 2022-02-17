import org.scalacheck.Properties
import CollectionOps._
import org.scalacheck.Prop.forAll

import scala.util.Random

object SortedSpec extends Properties("Sorting") {

  private def shuffle[A](list: List[A]): List[A] =
    new Random().shuffle(list)

}
