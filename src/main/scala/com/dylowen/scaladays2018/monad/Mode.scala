package com.dylowen.scaladays2018.monad

import cats.{Id, Monad, MonadError}
import com.dylowen.scaladays2018.monad.SyncMode.ErrorType

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.language.higherKinds
import scala.util.{Failure, Try}

/**
  * TODO add description
  *
  * @author dylan.owen
  * @since Jun-2018
  */
object Mode {

  object id {
    implicit val mode: Mode[Id, String] = IdMode
  }

  def sync[F[_] : ErrorType]: Mode[F, String] = SyncMode[F]()

  val `try_`: Mode[Try, String] = TryMode

  def async(implicit ec: ExecutionContext): Mode[Future, String] = AsyncMode()
}

trait Mode[F[_], E] {

  def pure[A](a: A): F[A]

  def async[A](future: Future[A]): F[A]

  def raiseError[A](error: E): F[A]
}

object SyncMode {
  type ErrorType[X[_]] = MonadError[X, String]
}

case class SyncMode[F[_] : ErrorType]() extends Mode[F, String] {

  override def pure[A](a: A): F[A] = MonadError[F, String].pure(a)

  override def async[A](future: Future[A]): F[A] = {
    Monad[F].pure(Await.result(future, Duration.Inf))
  }

  override def raiseError[A](error: String): F[A] = {
    MonadError[F, String].raiseError(error)
  }
}

object TryMode extends Mode[Try, String] {

  override def pure[A](a: A): Try[A] = Try(a)

  override def async[A](future: Future[A]): Try[A] = {
    Try(Await.result(future, Duration.Inf))
  }

  override def raiseError[A](error: String): Try[A] = {
    Failure(new RuntimeException(error))
  }
}

case class AsyncMode(implicit ec: ExecutionContext) extends Mode[Future, String] {

  override def pure[A](a: A): Future[A] = Future.successful(a)

  override def async[A](future: Future[A]): Future[A] = future

  override def raiseError[A](error: String): Future[A] = {
    Future.failed(new RuntimeException(error))
  }
}

object IdMode extends Mode[Id, String] {

  override def pure[A](a: A): Id[A] = a

  override def async[A](future: Future[A]): Id[A] = {
    Await.result(future, Duration.Inf)
  }

  override def raiseError[A](error: String): Id[A] = {
    throw new RuntimeException(error)
  }
}
