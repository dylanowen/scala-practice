# Scala Days NY 2018

## Dotty
[Schedule](https://na.scaladays.org/schedule/preparing-for-scala-3)

* http://dotty.epfl.ch/

## Typed Akka
[Schedule](https://na.scaladays.org/schedule/networks-and-types--the-future-of-akka)

* https://doc.akka.io/docs/akka/current/typed/index.html

## Twitter Code Tools
[Schedule](https://na.scaladays.org/schedule/how-we-built-tools-that-scale-to-millions-of-lines-of-code)

## Your Type System Working for You
[Schedule](https://na.scaladays.org/schedule/your-type-system-working-for-you)

Type everything so that your compiler can check correctness for you.
For example: 
```scala
case class FirstName(value: String)
case class LastName(value: String)

def name(first: FirstName, lastName: LastName): String

// fails to compile, where without the typing a bug would have occurred
val first = FirstName("first")
name(first, first)
``` 
* https://docs.scala-lang.org/overviews/core/value-classes.html

**Sample Code:** [ImplicitObjectType](./ImplicitObjectType.scala)

## Mutating The Immutable
[Schedule](https://na.scaladays.org/schedule/mutating-the-immutable--how-we-manage-change-in-large-scale-applications)

Morgan Stanley built a compiler plugin that operates on annotations that guarantee referential 
transparency so they can cache duplicated calls. They also have the ability to cache across updates 
based on the changes that apply to objects.

* https://skillsmatter.com/skillscasts/11182-automatic-parallelisation-and-batching-of-scala-code

They optimize some of their calls similar to how Incremental Lambda Calculus works.

## You are a Scala Contributor
[Schedule](https://na.scaladays.org/schedule/you-are-a-scala-contributor)

Contributing to Scala is easy :)

* https://github.com/scala/scala-lang/pull/919

## Type Parameter Power Up
[Schedule](https://na.scaladays.org/schedule/type-parameter-power-up-variance-bounds-and-inference)

Understanding variance, bounds and inference

* https://github.com/chrisphelps/type-parameter-power-up
* https://docs.scala-lang.org/tour/variances.html

**Sample Code:** [ContextBounds](./ContextBounds.scala)

## Functional Programming With Effects
[Schedule](https://na.scaladays.org/schedule/functional-programming-with-effects)

Good intro to monads and cats

**Sample Code:** [Monad](./monad)

## sttp: Scala Http Client
[Schedule](https://na.scaladays.org/schedule/sttp-the-scala-http-client-that-you-always-wanted)

* https://github.com/softwaremill/sttp

A very nice http client with a great interface

**Sample Code:** [sttp](./HttpClientSttp.scala)

## Differentiable Functional Programming
[Schedule](https://na.scaladays.org/schedule/differentiable-functional-programming)

* https://github.com/noelwelsh/fdl