package com.progrexor.photo.filemanager

import java.io.File
import java.nio.file._
import java.nio.file.attribute.BasicFileAttributes

class FileScanner extends SimpleFileVisitor[Path] {
  override def visitFile(file: Path, attrs: BasicFileAttributes): FileVisitResult = {
    println(s"file=${file.toString}")
    FileVisitResult.CONTINUE
  }
}


object FileScanner {

  def getFileList(root: String, recursionLevel: Int, pattern: List[String]): List[String] = {
    val folderToScan = new File(root)
    folderToScan.list.toList.filter(matchesAll(_, pattern))
    //TODO: Recursion for subfolders
  }

  def xxx(path: String) = {
    val startingPath = Paths.get(path)
    val x = Files.walkFileTree(startingPath, new FileScanner)
    println(s"x=${x}")
  }

  def matchesAll(string: String, pattern: List[String]) = pattern.map(string.matches(_)).foldLeft(false)(_ || _)
}
