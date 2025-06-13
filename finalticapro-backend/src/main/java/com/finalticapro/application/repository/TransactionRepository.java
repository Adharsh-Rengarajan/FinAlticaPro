package com.finalticapro.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finalticapro.application.entities.transaction.Transaction;

import jakarta.transaction.Transactional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	Transaction findByTransactionId(Long id);
	Transaction findByPaymentMethodType(String method);
	List<Transaction> findAllByUserId(Long id);
	
	@Modifying
	@Transactional
	@Query("DELETE from Transaction t where t.transactionId = :transactionId")
	void deleteAccount(@Param("transactionId") Long transactionId);
	
}
