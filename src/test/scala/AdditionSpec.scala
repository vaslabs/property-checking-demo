import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import Addition.Integers.add
import Addition.Strings.{add => s_add}

object AdditionSpec extends Properties("Addition"){

  property("Int Identity") = forAll { (a: Int) =>
    add(a, 0) == a
    add(0, a) == a
  }

  property("Int Inverse") = forAll { (a: Int, b: Int) =>
    add(add(a, b), -b) == a
    add(-b, add(a, b)) == a
  }

  property("Int Associative") = forAll { (a: Int, b: Int, c: Int) =>
    add(add(a, b), c) == add(a, add(b, c))
  }

  property("Int Commutative") = forAll { (a: Int, b: Int) =>
    add(a, b) == add(b, a)
  }

  property("String Identity") = forAll { (a: String) =>
    s_add(a, "") == a
    s_add("", a) == a
  }

  property("String Associative") = forAll { (a: String, b: String, c: String) =>
    s_add(s_add(a, b), c) == s_add(a, s_add(b, c))
  }

  property("String Commutative") = forAll { (a: String, b: String) =>
    s_add(a, b) == s_add(b, a)
  }

}
