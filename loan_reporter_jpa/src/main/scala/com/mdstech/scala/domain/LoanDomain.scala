package com.mdstech.scala.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 * @author Srini
 */

@Entity
class LoanDomain extends AbstractDomain {
  
  @Id
  @GeneratedValue
  private var id: java.lang.Long = 0
  
  private var amount:java.math.BigDecimal = _
  
  def getId:java.lang.Long = id
  def setId(id:java.lang.Long) = this.id = id
  
  def getAmount:java.math.BigDecimal = amount
  def setAmount(amount:java.math.BigDecimal) = this.amount = amount
}