package org.eternity.billing

case class Money(amount: Long) {
  def +(that: Money): Money = Money(this.amount + that.amount)
  
  def -(that: Money): Money = Money(this.amount - that.amount)
  
  def *(times: Double): Money = Money((this.amount.toDouble * times).toLong)
}