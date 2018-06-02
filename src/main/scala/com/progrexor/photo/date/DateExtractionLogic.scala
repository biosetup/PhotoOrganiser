package com.progrexor.photo.date

import java.text.SimpleDateFormat
import java.time.{LocalDate, LocalDateTime, LocalTime}
import java.time.format.DateTimeFormatter

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

  def getDatesX(fileMetaDataContainer: FileMetaDataContainer): List[(String, String)] = {
    dateTags
      .map(dateTag => (fileMetaDataContainer.getValue(dateTag.directoryName, dateTag.tagName), dateTag.directoryName+"_"+dateTag.tagName))
      .filter(_._1.isSuccess)
      .map(p => (p._1.get, p._2))
      .toList
  }

  def getTheDate(dates: List[String]): LocalDateTime = {
    val x = dates.map { date => date.length match {
        case 10 => LocalDateTime.from(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy:MM:dd")).atTime(LocalTime.MAX))
        case 19 => LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss"))
        case _ => LocalDateTime.now()
      }
    }
    println("=======")
    x.foreach(println)
    println("=======")
    LocalDateTime.now()
  }


}

case class DateTag(directoryName: String, tagName: String)