import org.scalacheck.Prop.forAll
import org.scalacheck.{Arbitrary, Gen, Properties}
import JsonExamples._
import io.circe._
import io.circe.syntax._
import io.circe.generic.auto._
import org.scalacheck.ScalacheckShapeless._

object JsonSpec extends Properties("Json") {

  property("object inverse") = forAll { (a: A) =>
    a.asJson.as[A] == Right(a)
  }

  property("allow extensions") = forAll { (a: A, json: Json) =>
    json.deepMerge(a.asJson).as[A] == Right(a)
  }


  implicit def arbitraryJson: Arbitrary[Json] = Arbitrary(genJsonObject)

  def genJsonObject: Gen[Json] = Gen.listOf(
    Gen.alphaNumStr.flatMap(key => genJson.map(key -> _))
  ).map(keys => Json.obj(keys:_*))

  def genJson = Gen.oneOf(
    Gen.const(Json.Null), genJsonBoolean, genJsonNumber, genJsonString
  )

  def genJsonBoolean = Gen.oneOf(Json.True, Json.False)
  def genJsonNumber = Gen.long.map(Json.fromLong)
  def genJsonString = Gen.asciiPrintableStr.map(Json.fromString)

  def genJsonArray = Gen.listOf(Gen.oneOf(genJsonBoolean, genJsonNumber, genJsonString))

}
