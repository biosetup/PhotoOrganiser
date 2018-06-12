package com.progrexor.photo.filemanager

import java.util.regex.Pattern

import org.scalatest.FlatSpec

class FileScannerSpec extends FlatSpec {

  behavior of "FileScannerSpec"

  it should "getFileList" in {
    val x = FileScanner.getFileList("", 0, List())
    x
  }

  it should "match again all patterns" in {
    val patternList = List("(?i).*\\.jpg", "(?i).*\\.png")
    val exampleFileNamesList = List("abs.jpg", "dot.jpg", "comma,jpg", "polo", "aFiLe.JpG", "", "x.jpg.qw", "oformat.png", "oformat.peng")
    val result = exampleFileNamesList.filter(FileScanner.matchesAll(_, patternList))
    assert(result === List("abs.jpg", "dot.jpg", "aFiLe.JpG", "oformat.png"))
  }
}
