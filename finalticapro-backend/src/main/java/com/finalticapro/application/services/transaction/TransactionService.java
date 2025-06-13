package com.finalticapro.application.services.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalticapro.application.entities.transaction.Transaction;
import com.finalticapro.application.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	
	public List<Transaction> getAllTransaction(Long userId)
	{
		return transactionRepository.findAllByUserId(userId);
	}
	
	public Transaction findByPaymentMethodType(String method)
	{
		return transactionRepository.findByPaymentMethodType(method);
	}
	
	public 	Transaction findByTransactionId(Long id)
	{
		return transactionRepository.findByTransactionId(id);
	}
	
	public void deleteAccount(Long transactionId)
	{
		 transactionRepository.deleteAccount(transactionId);
	}

	
	
}
