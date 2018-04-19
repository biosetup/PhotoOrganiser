package com.progrexor.photo.filescanner

import java.io.File

import com.drew.imaging.{ImageMetadataReader, ImageProcessingException}

import scala.collection.JavaConverters._

object FileMetaDataExtractor {
  def readMetadata(inputFile: File): FileMetaDataContainer = {
    try {
      FileMetaDataContainer(
        ImageMetadataReader
          .readMetadata(inputFile)
          .getDirectories.asScala.toList
          .flatMap { dir =>
            dir.getTags.asScala.toList
              .map { tag =>
                FileMetaDataItem(tag.getDirectoryName, tag.getTagName, tag.getDescription)
              }
          }
      )
    } catch {
      case e: ImageProcessingException =>
        FileMetaDataContainer(List())
    }
  }
}
