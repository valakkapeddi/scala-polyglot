package com.ky0dai

import org.junit.Test
import org.junit.Assert.assertTrue;

/**
 * Created by kyodai on 1/25/2016.
 */

@Test
class DiscountResourceGeneratorVersionTest {

  @Test
  def versionGreaterThanTwo() = {
    val resourceGenerator = new DiscountResourceGenerator();
    assertTrue(resourceGenerator.getVersion > 2)
  }

}
