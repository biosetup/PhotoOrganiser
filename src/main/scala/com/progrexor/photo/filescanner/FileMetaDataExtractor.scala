package com.progrexor.photo.filescanner

import java.io.File

import com.drew.imaging.{ImageMetadataReader, ImageProcessingException}
import com.drew.metadata.{Directory, Metadata}

import scala.collection.JavaConverters._

object FileMetaDataExtractor {

  private var metaDetected = true

  def readMetadata(inputFile: File): List[Directory] = {
//    val metadata = ImageMetadataReader.readMetadata(inputFile)

    val res = try {
      ImageMetadataReader.readMetadata(inputFile).getDirectories.asScala.toList
    } catch {
      case e: ImageProcessingException =>
        metaDetected = false
        List()
    }

    println(s" metaDetected: ${metaDetected}")
    res

    //FileMetaData("aaa", "bbb")
  }
}
