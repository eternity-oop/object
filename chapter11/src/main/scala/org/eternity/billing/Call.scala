package org.eternity.billing

import java.time._

case class Call(val from: LocalDateTime, val to: LocalDateTime) {
  def duration: Duration = Duration.between(from, to)  
}