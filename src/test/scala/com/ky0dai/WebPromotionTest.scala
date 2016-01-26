package com.ky0dai

import org.junit.Assert._
import org.junit.Test
import scala.xml.{Elem, XML}

/**
 * Created by kyodai on 1/25/2016.
 */

@Test
class WebPromotionTest {

  private def selectDiscountByType(shippingResourceAsXml:Elem, x:String) = shippingResourceAsXml \ "discounts" filter(y => (y \ "type").text == x)

  @Test
  def webPromotionShouldContainOnlyTwoDiscounts() = {
    val shippingResourceAsXml = XML.loadString(new DiscountResourceGenerator().getWebPromotionResource)

    val discounts = shippingResourceAsXml \ "discounts"
    val numberOfDiscounts = discounts.length

    val discountTypes = (discounts \ "type").map(_.text)
    val expectedDiscountTypes = List("Purchase", "Shipping")

    assertTrue(expectedDiscountTypes.diff(discountTypes) == List())
  }

  @Test
  def purchaseDiscountShouldBe10Percent() = {
    val shippingResourceAsXml = XML.loadString(new DiscountResourceGenerator().getWebPromotionResource)

    val purchaseDiscount = selectDiscountByType(shippingResourceAsXml, "Purchase") \ "discountAmount"
    assertEquals("0.1", purchaseDiscount.text)
  }
  
  @Test
  def shippingDiscountShouldBe50Percent() = {
    val shippingResourceAsXml = XML.loadString(new DiscountResourceGenerator().getWebPromotionResource)

    val shippingDiscount = selectDiscountByType(shippingResourceAsXml, "Shipping") \ "discountAmount"
    assertEquals("0.5", shippingDiscount.text)
  }

}
