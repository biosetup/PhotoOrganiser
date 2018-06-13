package com.progrexor.photo.filemanager

import java.io.File
import java.util.regex.Pattern

import org.scalatest.FlatSpec

class FileScannerSpec extends FlatSpec {

  behavior of "FileScanner"

  it should "get list of files which are matching given patterns" in {
    val patternList = List("(?i).*\\.jpg", "(?i).*\\.png")
    val rootPath = getClass.getResource("/").getPath
    val folderToScan = rootPath + "folder1"
    val result = FileScanner.getFileList(folderToScan, 0, patternList)
    println(result)
    assert(result === List("file1FromFolder1.jpg", "afile2.JPG"))
  }

  it should "match again all patterns" in {
    val patternList = List("(?i).*\\.jpg", "(?i).*\\.png")
    val exampleFileNamesList = List("abs.jpg", "dot.jpg", "comma,jpg", "polo", "aFiLe.JpG", "", "x.jpg.qw", "oformat.png", "oformat.peng")
    val result = exampleFileNamesList.filter(FileScanner.matchesAll(_, patternList))
    assert(result === List("abs.jpg", "dot.jpg", "aFiLe.JpG", "oformat.png"))
  }
}
