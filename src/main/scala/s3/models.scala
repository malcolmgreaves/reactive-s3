package com.nitro.iterator.s3

import java.util.Date

import com.amazonaws.services.s3.model.{ ObjectListing, S3ObjectSummary => JObjectSummary }
import com.nitro.iterator.models.Pageable

import scala.collection.JavaConversions._

case class S3ObjectListing(underlying: ObjectListing) extends Pageable {

  val objectSummaries: List[S3ObjectSummary] = underlying.getObjectSummaries.map(jSummary => new S3ObjectSummary(jSummary)).toList

  val nextMarker: Option[String] = Option(underlying.getNextMarker)

  override val next = nextMarker
}

case class S3ObjectSummary(underlying: JObjectSummary) {

  val bucketName: String = Option(underlying.getBucketName).getOrElse("")

  val key: String = Option(underlying.getKey).getOrElse("")

  /**
   * downstream code should handle the nullable
   */
  val lastModified: Option[Date] = Option(underlying.getLastModified)
}
