import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import Addition.Integers.add
import Addition.Strings.{add => s_add}

object AdditionSpec extends Properties("Addition"){
  property("int identity") = forAll { (a: Int) =>
    add(a, 0) == a && add(0, a) == a
  }

  property("int inverse") = forAll { (a: Int, b: Int) =>
    add(add(a, b), -b) == a && add(-b, add(a, b)) == a
  }

  property("Int Associative") = forAll { (a: Int, b: Int, c: Int) =>
    add(add(a, b), c) == add(a, add(b, c))
  }

  property("Int Commutative") = forAll { (a: Int, b: Int) =>
    add(a, b) == add(b, a)
  }

  property("String identity") = forAll { (a: String) =>
    s_add("", a) == a && s_add(a, "") == a
  }

  property("String Commutative") = forAll { (a: String, b: String) =>
    s_add(a, b) == s_add(b, a)
  }

}
