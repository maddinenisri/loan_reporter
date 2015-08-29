package com.mdstech.scala.domain

import javax.persistence.Entity
import javax.persistence.MappedSuperclass
import javax.persistence.Id
import javax.persistence.GeneratedValue

/**
 * @author Srini
 */

@Entity
class LoanDomain extends AbstractDomain {
  
  @Id
  @GeneratedValue
  private var id: java.lang.Long = 0
  
  private var amount:BigDecimal = _
  
  def getId:java.lang.Long = id
  def setId(id:java.lang.Long) = this.id = id
  
  def getAmount:BigDecimal = amount
  def setAmount(amount:BigDecimal) = this.amount = amount
}