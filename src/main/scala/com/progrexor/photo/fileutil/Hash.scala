package com.progrexor.photo.fileutil

import java.io.InputStream
import java.security.MessageDigest

object Hash {

  def getHash(inputStream: InputStream): String = {
    val digest = MessageDigest.getInstance("SHA-256")
    digest.digest(Stream.continually(inputStream.read).takeWhile(_ != -1).map(_.toByte).toArray).map("%02X" format _).mkString
  }

}
