package com.mdstech.scala.domain

import java.util.Date

import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

/**
 * @author Srini
 */

@MappedSuperclass
abstract class AbstractDomain {
  var createdDate : Date = _
  var updatedDate : Date = _
  
  @PrePersist
  def prePersist = {
    createdDate = new Date
    updatedDate = new Date
  }
  
  @PreUpdate
  def preUpdate = {
    updatedDate = new Date
  }
  
  def getCreatedDate:Date = createdDate
  def getUpdatedDate:Date = updatedDate
  
  def setcreatedDate(createdDate: Date) = this.createdDate = createdDate
  def setUpdatedDate(updatedDate:Date) = this.updatedDate = updatedDate
}