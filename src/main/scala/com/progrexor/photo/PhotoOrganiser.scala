package com.progrexor.photo

import com.progrexor.photo.filemanager.CopyFile
import com.typesafe.config.{Config, ConfigFactory}

import scala.collection.JavaConverters._

object PhotoOrganiser {

  def main(args: Array[String]): Unit = {
    println("Start")
    //TODO Traverse through all folders, param for recursive search
    //TODO Traverse through list of source folders, param for recursive search
    //TODO Detect meta
    //TODO Record the meta into DB
    //TODO To have an option to build transformation plan first and then perform transformation using information from DB or do it on the fly
    //TODO Create path according to the meta info
    //TODO Copy/move source file into the destination


    implicit val config = ConfigFactory.load()


    println(config.getString("move-files"))

    CopyFile().copy(
      "/Users/andreyd/dev/photo/PhotoOrganiser/src/main/resources/application2.conf",
      "/Users/andreyd/dev/photo/PhotoOrganiser/src/main/resources/application2_copy3.conf")

  }

}

