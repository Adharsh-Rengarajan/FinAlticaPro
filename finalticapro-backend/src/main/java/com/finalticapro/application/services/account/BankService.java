package com.finalticapro.application.services.account;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalticapro.application.entities.account.BankAccount;
import com.finalticapro.application.repository.BankRepository;

@Service
public class BankService {
    
    @Autowired
    private BankRepository bankRepository;
    
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
    
    public void depositAmount(Long accountId, BigDecimal amount) {
        Optional<BankAccount> optionalAccount = bankRepository.findById(accountId);
        if (optionalAccount.isEmpty()) {
            throw new RuntimeException("Account not found");
        }
        
        BankAccount bankAccount = optionalAccount.get();
        BigDecimal newBalance = bankAccount.getBalance().add(amount);
        bankRepository.updateBalance(accountId, newBalance);
    }
    
    public void withDraw(Long accountId, BigDecimal amount) {
        Optional<BankAccount> optionalAccount = bankRepository.findById(accountId);
        if (optionalAccount.isEmpty()) {
            throw new RuntimeException("Account not found");
        }
        
        BankAccount bankAccount = optionalAccount.get();
        if (bankAccount.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance for withdrawal");
        }
        
        BigDecimal newBalance = bankAccount.getBalance().subtract(amount);
        bankRepository.updateBalance(accountId, newBalance);
    }
    
    public void updateBalance(Long accountId, BigDecimal amount) {
        bankRepository.updateBalance(accountId, amount);
    }
    
    public void updateCurrency(Long accountId, String currency) {
        bankRepository.updateCurrencyType(accountId, currency);
    }
    
    public List<BankAccount> getAllAccounts(Long userId) {
        return bankRepository.findByUserUserId(userId); 
    }
    
    public void deleteAccount(Long accountId) {
        if (!bankRepository.existsById(accountId)) {
            throw new RuntimeException("Account not found");
        }
        bankRepository.deleteAccount(accountId);
    }
}