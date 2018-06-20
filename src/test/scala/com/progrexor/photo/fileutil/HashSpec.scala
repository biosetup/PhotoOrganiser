package com.progrexor.photo.fileutil

import org.scalatest.FlatSpec

class HashSpec extends FlatSpec {

  behavior of "Hash"

  it should "generate correct SHA-256 of the given files" in {
    assert(Hash.getHash(getClass.getResourceAsStream("/test_1.tiff")) === "BE28B5A40AD84FBEB9A2FA8FB34FE16CD22560FF7D0CF70CFAD3DA8183D02B21")
  }

}

//TODO: Fill the table with
// original path
// scan datetime
// meta datetime
// meta info
// hash sha-256