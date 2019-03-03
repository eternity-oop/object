package org.eternity.billing

import java.time._

object Main extends App {
  val traitPhone = new Phone(
        List(Call(LocalDateTime.of(2017,1,2,10,0), LocalDateTime.of(2017,1,2,10,1))),
        new RegularPolicy(Money(100), Duration.ofSeconds(10)) with RateDiscountablePolicy with TaxablePolicy {
                      val discountAmount = Money(100)
                      val taxRate = 0.02
                    })
  println(traitPhone.calculateFee)
  
  val traitPhone2 = new Phone(
        List(Call(LocalDateTime.of(2017,1,2,10,0), LocalDateTime.of(2017,1,2,10,1))),
        new RegularPolicy(Money(100), Duration.ofSeconds(10)) with TaxablePolicy with RateDiscountablePolicy {
                      val discountAmount = Money(100)
                      val taxRate = 0.02
                    })
  println(traitPhone2.calculateFee)
  
}