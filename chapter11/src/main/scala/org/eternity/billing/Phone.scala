package org.eternity.billing

class Phone(val calls: List[Call], private val ratePolicy: BasicRatePolicy) {  
  def calculateFee(): Money = ratePolicy.calculateFee(this)
}