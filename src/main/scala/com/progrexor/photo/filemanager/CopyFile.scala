package com.progrexor.photo.filemanager

import java.nio.file._

import com.typesafe.config.Config

class CopyFile(config: Config) {

  def copy(src: String, dst: String): Unit = {
    val srcPath: Path = FileSystems.getDefault.getPath(src)
    val dstPath: Path = FileSystems.getDefault.getPath(dst)
    val x = Files.copy(srcPath, dstPath, StandardCopyOption.REPLACE_EXISTING)
  }

}

object CopyFile {
  def apply()(implicit config: Config): CopyFile = new CopyFile(config)
}
