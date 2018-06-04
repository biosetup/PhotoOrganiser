package com.progrexor.photo.db

import org.scalatest.FlatSpec

class ManagerTest extends FlatSpec {

  behavior of "ManagerTest"

  it should "printDBInfo" in {
    Manager.printDBInfo
    //Manager.createEmptyTable
    Manager.selectAll
    Manager.insertName("AAA")
    Manager.selectAll
  }

}
