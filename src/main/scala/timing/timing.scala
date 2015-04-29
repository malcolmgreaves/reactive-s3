package com.nitro.iterator.timing

import com.nitro.iterator.logging
import com.nitro.iterator.logging._
import org.joda.time.DateTime

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Success

object Timing {

  private lazy val logger = Log.getLogger[Timing.type]

  def time[T](name: String, threshold: Long = 1000)(operation: => T): T = {
    val start = (new DateTime).getMillis

    val t = operation

    val duration = (new DateTime).getMillis - start
    if (duration > threshold)
      logger.warn(s"[Time] Operation [$name] took [$duration ms]")
    else
      logger.info(s"[Time] Operation [$name] took [$duration ms]")
    t
  }

  def timeAsync[T](name: String, threshold: Long = 1000)(operation: => Future[T]): Future[T] = {
    val start = (new DateTime).getMillis

    val futureT = operation

    futureT andThen {
      case Success(t) =>
        val duration = (new DateTime).getMillis - start
        if (duration > threshold)
          logger.warn(s"[Time] Operation [$name] took [$duration ms]")
        else
          logger.info(s"[Time] Operation [$name] took [$duration ms]")
        t
    }
  }
}
