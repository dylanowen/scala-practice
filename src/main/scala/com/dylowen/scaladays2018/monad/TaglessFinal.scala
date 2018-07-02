package com.dylowen.scaladays2018.monad

import cats.{Id, Monad}
import cats.implicits._
import com.dylowen.monad.Jwt

import scala.concurrent.Future
import scala.language.higherKinds
import scala.util.{Failure, Success, Try}
import scala.util.control.NonFatal

/**
  * TODO add description
  *
  * @author dylan.owen
  * @since Jun-2018
  */
object TaglessFinal {

  object JwtValidator {

    import scala.concurrent.ExecutionContext.Implicits.global

    def validateAndExtract[F[_] : Monad](str: String)(implicit mode: Mode[F, String]): F[String] = {
      mode.pure(str).flatMap[Jwt]((rawJwt: String) => {
        val arr = rawJwt.split('.')
        if (arr.length == 2) {
          mode.pure(Jwt(arr(0), arr(1)))
        }
        else {
          mode.raiseError("Invalid jwt")
        }
      })
        .flatMap((jwt: Jwt) => {
          mode.async(validateJwt(jwt))
        })
        .flatMap((result: Either[String, Jwt]) => {
          result match {
            case Right(jwt) => mode.pure(jwt.body)
            case Left(error) => mode.raiseError(error)
          }
        })
    }

    def validateJwt(jwt: Jwt): Future[Either[String, Jwt]] = {
      Future({
        if (jwt.head == "head") {
          Right(jwt)
        }
        else {
          Left("bad jwt callback")
        }
      })
    }
  }

  def main(args: Array[String]): Unit = {
    {
      type EitherError[X] = Either[String, X]
      implicit val mode: Mode[EitherError, String] = Mode.sync[EitherError]

      JwtValidator.validateAndExtract[EitherError]("head.body")
        .map(str => {
          println("either result success")
        })

      JwtValidator.validateAndExtract[EitherError]("bad.body")
      match {
        case Right(str) => println("what")
        case Left(str) => println("either " + str)
      }
    }
    {
      //type EitherError[X] = Either[String, X]
      implicit val mode: Mode[Try, String] = Mode.try_

      JwtValidator.validateAndExtract[Try]("head.body")
        .map(str => {
          println("try result success")
        })

      JwtValidator.validateAndExtract[Try]("bad.body")
      match {
        case Success(str) => println("what")
        case Failure(str) => println("try " + str.getMessage)
      }
    }
    {
      implicit val mode: Mode[Id, String] = Mode.id.mode

      println(JwtValidator.validateAndExtract[Id]("head.body"))

      try {
        JwtValidator.validateAndExtract[Id]("bad.body")
      }
      catch {
        case NonFatal(e) => println("id " + e.getMessage)
      }
    }
    {
      import scala.concurrent.ExecutionContext.Implicits.global

      implicit val mode: Mode[Future, String] = Mode.async

      JwtValidator.validateAndExtract[Future]("head.body")
        .map(str => {
          println("future result success")
        })

      JwtValidator.validateAndExtract[Future]("bad.body")
        .failed.foreach({
        case NonFatal(e) => println("future " + e.getMessage)
      })

      Thread.sleep(1000)
    }
  }
}