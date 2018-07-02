package com.dylowen.scaladays2018

import com.softwaremill.sttp._
import com.softwaremill.sttp.asynchttpclient.future.AsyncHttpClientFutureBackend

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * This example is of the Http Client STTP
  * https://github.com/softwaremill/sttp
  *
  * It's API is very nice, especially for testing and swapping out the backend.
  *
  * [[SttpBackend]] provides an interface that can be async or sync based on how the
  * client uses it
  *
  * @author dylan.owen
  * @since Jun-2018
  */
object HttpClientSttp {
  def main(args: Array[String]): Unit = {
    val req = sttp.get(uri"http://api.bart.gov/api/etd.aspx?cmd=etd&orig=12th")
      .response(asString.map(_.split(" ")))

    implicit val backend = AsyncHttpClientFutureBackend()


    req.send().map(_.body)
  }
}
