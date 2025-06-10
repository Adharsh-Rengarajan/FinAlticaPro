package com.finalticapro.application.services.account;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalticapro.application.entities.account.BankAccount;
import com.finalticapro.application.repository.BankRepository;

@Service
public class BankService {

	@Autowired
	public BankRepository bankRepository;
	
	 public BankAccount createAccount(BankAccount account) {
	        if (account == null || account.getUser() == null) {
	            throw new IllegalArgumentException("Account and user cannot be null");
	        }
	        
	        boolean accountExists = bankRepository.existsByUserUserIdAndBankNameAndAccountType(
	            account.getUser().getUserId(),
	            account.getBankName(),
	            account.getAccountType()
	        );
	        
	        if (accountExists) {
	            throw new RuntimeException(
	                "Account already exists for bank: " + account.getBankName() + 
	                " and type: " + account.getAccountType()
	            );
	        }
	        
	        return bankRepository.save(account);
	    }
	 
	 public BigDecimal depositAmount(long accountId, BigDecimal amount)
	 {
		 BankAccount bankAccount=bankRepository.findById(accountId);
		 amount=bankAccount.getBalance().add(amount);
		 return bankRepository.updateBalance(accountId, amount);
	 }
	 
	 public BigDecimal withDraw(long accountId, BigDecimal amount)
	 {
		 BankAccount bankAccount=bankRepository.findById(accountId);
		 if(bankAccount.getBalance().compareTo(amount) < 0)
		 {
			 throw new RuntimeException("You cannot withdraw the amount greater than your balance");
		 }
		 amount=bankAccount.getBalance().add(amount);
		 
		 return bankRepository.updateBalance(accountId, amount);
	 }
	
	 
	 public BigDecimal updateBalance(long accountId, BigDecimal amount)
	 {
		 return bankRepository.updateBalance(accountId, amount);
	 }
	 
	 public String updateCurrency(long accountId, String currency)
	 {
		 return bankRepository.updateCurrencyType(accountId, currency);
	 }
	 
	 public List<BankAccount> getAllAccounts(long accountId)
	 {
		 return bankRepository.findAllById(accountId);
	 }
	 
	 public void deleteAccount(long accountId)
	 {
		 bankRepository.deleteAccount(accountId);
	 }
}