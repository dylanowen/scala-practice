package com.dylowen.implicits

import scala.reflect.ClassTag

/**
  * TODO add description
  *
  * @author dylan.owen
  * @since Feb-2019
  */
object ImplicitEvidence {

  def main(args: Array[String]): Unit = {
    val things: Seq[Any] = Seq(
      "test",
      1,
      "test2",
      2,
      "test3"
    )

    print[Int](things)
    printLevel1[Int](things)
    printLevel2[Int](things)
  }

  def print[T: ClassTag](things: Seq[Any]): Unit = {
    things
      .foreach({
        case t: T => println(t)
        case _ => // noop
      })
  }

  def printLevel1[T](things: Seq[Any])(implicit evidence: ClassTag[T]): Unit = {
    things
      .foreach({
        case t: T => println(t)
        case _ => // noop
      })
  }

  def printLevel2[T](things: Seq[Any])(implicit evidence: ClassTag[T]): Unit = {
    things
      .foreach({
        case t@evidence(_: T) => println(t)
        case _ => // noop
      })
  }
}
