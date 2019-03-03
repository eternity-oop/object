package org.eternity.billing

abstract class BasicRatePolicy {
  def calculateFee(phone: Phone): Money = phone.calls.map(calculateCallFee(_)).reduce(_ + _)
  
  protected def calculateCallFee(call: Call): Money;
}