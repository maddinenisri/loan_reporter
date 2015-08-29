package com.mdstech.scala.repository


import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import com.mdstech.scala.config.SpringDataContextConfiguration
import com.mdstech.scala.domain.LoanDomain

import javax.persistence.Entity

/**
 * @author Srini
 */
@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(classes = Array(classOf[SpringDataContextConfiguration]))
class LoanRepositoryTest {
 
  @Autowired 
  private val loanRepostiory : LoanRepository = null
  
  @Test
  def testLoanCreate() = {
    val loanDomain = new LoanDomain
    loanDomain.setAmount(new java.math.BigDecimal("23400.00"))
    val savedLoanDomain = loanRepostiory.save(loanDomain)
    assertNotNull("Object Saved", savedLoanDomain.getId)
  }
}