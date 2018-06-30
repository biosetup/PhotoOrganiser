package com.progrexor.photo.actors

import akka.actor.{Actor, Props}

class FileRegistrator extends Actor {

  override def receive: Receive = {
    case str: String => {
      Thread.sleep(500)
      println(s"Print from actor: ${str}")
    }
  }

}

object FileRegistrator {
  def props: Props = Props[FileRegistrator]
}
