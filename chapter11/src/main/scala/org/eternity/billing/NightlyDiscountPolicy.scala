package org.eternity.billing

import java.time.Duration

class NightlyDiscountPolicy(
    val nightlyAmount: Money,  
    val regularAmount: Money,
    val seconds: Duration) extends BasicRatePolicy {   
  
  override protected def calculateCallFee(call: Call): Money =
    if (call.from.getHour >= NightltDiscountPolicy.LateNightHour) {
      nightlyAmount * (call.duration.getSeconds / seconds.getSeconds)
    } else {
      regularAmount * (call.duration.getSeconds / seconds.getSeconds)
    }
}

object NightltDiscountPolicy {
  val LateNightHour: Integer = 22
}

