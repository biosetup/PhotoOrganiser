package com.progrexor.photo.filescanner

import java.io.File

import com.progrexor.photo.date.DateExtractionLogic
import com.typesafe.config.ConfigFactory
import org.scalatest.FlatSpec

import scala.collection.JavaConverters._
import scala.io.Source

class FileMetaDataExtractorSpec extends FlatSpec {

  implicit val config = ConfigFactory.load()

  behavior of "FileMetaDataExtractor"

  it should "readMetadata" in {

//    Source.fromURL(getClass.getResource("/test_sony.jpg"))
    val inputFile = getClass.getResource("/vid_sony2.mp4").getFile
    val dirs = FileMetaDataExtractor.readMetadata(new File(inputFile))
    println(dirs)
    dirs.fileMetaDataContainer.foreach(println)
    println(dirs.getValue("File", "File Modified Date"))
    println(dirs.getValue("MP4", "Duration"))

    val dateExtractionLogic = new DateExtractionLogic()

    dateExtractionLogic.getDates(dirs).foreach(println)
  }

}

// [Exif IFD0] Date/Time - 1998:12:01 14:22:36
// [Exif SubIFD] Date/Time Original - 1998:12:01 14:22:36
// [Exif SubIFD] Date/Time Digitized - 1998:12:01 14:22:36
// [File] File Modified Date - Tue Mar 06 23:38:05 +00:00 2018
// [GPS] GPS Date Stamp - 2008:10:23
// [GPS] GPS Time-Stamp - 14:27:07.240 UTC
// [MP4] Creation Time - Wed Jul 04 14:42:03 BST 2012
// [MP4] Modification Time - Wed Jul 04 14:42:04 BST 2012
// [MP4 Video] Vendor - Wed Jul 04 14:42:03 BST 2012
// [MP4 Video] Temporal Quality - Wed Jul 04 14:42:04 BST 2012
// [MP4 Sound] Format - Wed Jul 04 14:42:03 BST 2012
// [QuickTime] Creation Time - Sat Jul 07 05:55:17 +01:00 2012
// [QuickTime] Modification Time - Sat Jul 07 05:55:17 +01:00 2012
// [QuickTime Video] Creation Time - Sat Jul 07 05:55:17 BST 2012
// [QuickTime Video] Modification Time - Sat Jul 07 05:55:17 BST 2012
// [QuickTime Sound] Creation Time - Sat Jul 07 05:55:17 BST 2012
// [QuickTime Sound] Modification Time - Sat Jul 07 05:55:17 BST 2012

// File Modified Date - Tue Mar 06 23:38:05 +00:00 2018
//  Modification Time - Sat Jul 07 05:55:17 +01:00 2012


// YYYY:MM:DD HH:MM:SS
// 1998:12:01 14:22:36

// YYYY:MM:DD
// 2008:10:23

// HH:MM:SS.sss ZZZ
// 14:27:07.240 UTC

// WWW MON DD HH:MM:SS ZZZ YYYY
// Wed Jul 04 14:42:03 BST 2012

// WWW MON DD HH:MM:SS +HH:MM YYYY
// Tue Mar 06 23:38:05 +00:00 2018

// WWW MON DD HH:MM:SS +HH:MM YYYY
// Sat Jul 07 05:55:17 +01:00 2012


// YYYY:MM:DD
// HH:MM:SS.sss ZZZ
// YYYY:MM:DD HH:MM:SS
// WWW MON DD HH:MM:SS ZZZ YYYY
// WWW MON DD HH:MM:SS +HH:MM YYYY
