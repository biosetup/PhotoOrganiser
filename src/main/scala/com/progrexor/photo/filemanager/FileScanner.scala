package com.progrexor.photo.filemanager

import java.io.File

object FileScanner {

  def getFileList(root: String, recursionLevel: Int, pattern: List[String]): List[String] = {
    val folderToScan = new File(root)
    folderToScan.list.toList.filter(matchesAll(_, pattern))
    //TODO: Recursion for subfolders
  }

  def matchesAll(string: String, pattern: List[String]) = pattern.map(string.matches(_)).foldLeft(false)(_ || _)
}
