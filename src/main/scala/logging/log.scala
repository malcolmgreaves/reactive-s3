package com.nitro.iterator.logging

import org.slf4j.{ Logger, LoggerFactory }

import scala.reflect.ClassTag

object Log {

  def getLogger[T](implicit classTag: ClassTag[T]): Logger = LoggerFactory.getLogger(classTag.runtimeClass)
  def getLogger(name: String): Logger = LoggerFactory.getLogger(name)
}

