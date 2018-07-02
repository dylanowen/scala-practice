package com.dylowen.scaladays2018

/**
  * TODO add description
  *
  * @author dylan.owen
  * @since Jun-2018
  */

trait Adder[A] {
  def add(x: A, y: A): A
}

object ContextBounds {

  // https://github.com/chrisphelps/type-parameter-power-up

  def main(args: Array[String]): Unit = {
    implicit val IntAdder = new Adder[Int] {
      override def add(x: Int, y: Int): Int = x + y
    }

    add(1, 2)
    add2(1, 2)

    implicit val strAdder = new Adder[String] {
      override def add(x: String, y: String): String = x + y
    }

    add("", "")
    add2("", "")
  }

  def add[A: Adder](a: A, b: A): A = {
    val adder = implicitly[Adder[A]]

    adder.add(a, b)
  }

  // these 2 methods mean the same thing but it's better to write it this way. The upper one is just syntactic sugar
  def add2[A](a: A, b: A)(implicit adder: Adder[A]): A = {
    adder.add(a, b)
  }
}


