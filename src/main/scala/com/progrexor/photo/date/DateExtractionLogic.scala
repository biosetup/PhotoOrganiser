package com.progrexor.photo.date

import java.time.ZonedDateTime

import com.drew.metadata.Directory
import com.progrexor.photo.filescanner.FileMetaDataContainer
import com.typesafe.config.Config

import scala.collection.JavaConverters._

class DateExtractionLogic(implicit config: Config) {
  //TODO Use median date value within tolerance level from base date

  val dateTags = config.getConfigList("dates").asScala.map(p => DateTag(p.getString("directoryName"), p.getString("tagName")))

  def getDates(fileMetaDataContainer: FileMetaDataContainer): List[String] = {
    dateTags.map(dateTag => fileMetaDataContainer.getValue(dateTag.directoryName, dateTag.tagName)).filter(_.isSuccess).map(_.get).toList
  }

  def getTheDate(metadata: List[Directory]): ZonedDateTime = {
    ZonedDateTime.now()
  }


}

case class DateTag(directoryName: String, tagName: String)