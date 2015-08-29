package com.mdstech.scala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdstech.scala.domain.LoanDomain;

@Repository
public interface LoanRepository extends JpaRepository<LoanDomain, Long> {

}
