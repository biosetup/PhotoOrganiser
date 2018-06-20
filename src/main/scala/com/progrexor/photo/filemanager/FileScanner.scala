package com.progrexor.photo.filemanager

import java.io.File
import java.nio.file._
import java.nio.file.attribute.BasicFileAttributes

import akka.actor.ActorRef

class FileScanner(actorRef: ActorRef) extends SimpleFileVisitor[Path] {
  override def visitFile(file: Path, attrs: BasicFileAttributes): FileVisitResult = {
    //println(s"file=${file.toString}")
    actorRef ! file.toString
    FileVisitResult.CONTINUE
    //TODO: Apply filename filter
    //TODO: (ACTOR) Call an actor (FileRegistratorActor)
    //TODO: (ACTOR) Get meta info
    //TODO: (ACTOR) Register in the DB
  }
}


object FileScanner {

  def getFileList(root: String, recursionLevel: Int, pattern: List[String]): List[String] = {
    val folderToScan = new File(root)
    folderToScan.list.toList.filter(matchesAll(_, pattern))
    //TODO: Recursion for subfolders
  }

  def xxx(path: String, actorRef: ActorRef) = {
    val startingPath = Paths.get(path)
    val x = Files.walkFileTree(startingPath, new FileScanner(actorRef))
    println(s"x=${x}")
  }

  def matchesAll(string: String, pattern: List[String]) = pattern.map(string.matches(_)).foldLeft(false)(_ || _)
}
