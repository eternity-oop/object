package org.eternity.billing.mixedin

import org.eternity.billing._
import java.time._

class RateDiscountableAndTaxableRegularPolicy(
    amount: Money, 
    seconds: Duration, 
    val discountAmount: Money,
    val taxRate: Double)
  extends RegularPolicy(amount, seconds)
  with TaxablePolicy 
  with RateDiscountablePolicy
  
class TaxableAndRateDiscountableRegularPolicy(
    amount: Money, 
    seconds: Duration, 
    val discountAmount: Money,
    val taxRate: Double)
  extends RegularPolicy(amount, seconds) 
  with RateDiscountablePolicy 
  with TaxablePolicy
