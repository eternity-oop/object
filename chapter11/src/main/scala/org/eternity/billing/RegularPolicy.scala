package org.eternity.billing

import java.time.Duration

class RegularPolicy(val amount: Money, val seconds: Duration) extends BasicRatePolicy {
  override protected def calculateCallFee(call: Call): Money = amount * (call.duration.getSeconds / seconds.getSeconds)
}