package com.progrexor.photo.filemanager

import java.io.File
import scala.collection.JavaConverters._

object FileScanner {

  def getFileList(root: String, recursionLevel: Int, pattern: List[String]) = {
    val x = getClass.getResource("/folder1").getPath
    println(x)
    val f = new File(x)
    val s = f.list.toList
    println(s)
  }

  def matchesAll(string: String, pattern: List[String]) = pattern.map(string.matches(_)).foldLeft(false)(_ || _)
}
