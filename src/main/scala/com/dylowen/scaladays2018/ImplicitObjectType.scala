package com.dylowen.scaladays2018

/**
  * This example showcases using a trait with an object to provide automatic implicit
  * resolution
  *
  * @author dylan.owen
  * @since Jun-2018
  */
trait ObjectType[T] {

  implicit def impl: T

}

object ImplicitObjectType extends ObjectType[ImplicitObjectType] {
  override implicit def impl: ImplicitObjectType = apply()
}

case class ImplicitObjectType() {
  def test(): String = "test"
}

object Test {
  def main(args: Array[String]): Unit = {

    val test = implicitly[ImplicitObjectType]

    test.test()
  }
}