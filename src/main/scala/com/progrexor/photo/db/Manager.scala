package com.progrexor.photo.db

import java.sql.DriverManager
import scala.collection.JavaConverters._

object Manager {
  lazy val connection = {
    Class.forName("org.h2.Driver")
    DriverManager.getConnection("jdbc:h2:mem:test")
  }

  lazy val statement = connection.createStatement()

  def printDBInfo = {
    println(s"Catalog: ${connection.getCatalog}")
    println(s"Schema: ${connection.getSchema}")
    println(s"ClientInfo: ${connection.getClientInfo}")

  }

  def createEmptyTable = {
    statement.execute("create table photos(name varchar)")
  }

  def selectAll = {
    val result = statement.executeQuery("select * from photos")
    while (result.next()) {
      println(result.getString("name"))
    }
  }

  def insertName(name: String) = {
    statement.execute(s"insert into photos values('${name}')")
  }
}
