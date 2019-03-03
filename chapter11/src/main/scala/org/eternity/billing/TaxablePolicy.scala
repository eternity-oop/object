package org.eternity.billing

trait TaxablePolicy extends BasicRatePolicy {
  val taxRate: Double
  override def calculateFee(phone: Phone): Money = {
    val fee = super.calculateFee(phone)
    return fee + fee * taxRate
  }
}
