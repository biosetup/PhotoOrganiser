package com.progrexor.photo.filescanner

import scala.util.Try

case class FileMetaDataContainer(fileMetaDataContainer: List[FileMetaDataItem]) {
  def getValue(directoryName: String, tagName: String) = {
    Try(
    fileMetaDataContainer
      .filter(_.directoryName == directoryName)
      .filter(_.tagName == tagName)
      .head.description
    )
  }
}

