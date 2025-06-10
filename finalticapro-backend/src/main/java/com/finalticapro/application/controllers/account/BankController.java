package com.finalticapro.application.controllers.account;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.finalticapro.application.dto.accounts.BankAccountRequestDTO;
import com.finalticapro.application.entities.account.BankAccount;
import com.finalticapro.application.entities.user.User;
import com.finalticapro.application.services.account.BankService;
import com.finalticapro.application.services.UserService;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/create")
    public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccountRequestDTO bankAccountDTO) {
        try {
            User user = userService.findById(bankAccountDTO.getUserId());
            
            BankAccount account = new BankAccount(
                user,
                bankAccountDTO.getBankName(),
                bankAccountDTO.getAccountType(),
                bankAccountDTO.getAccountNumber(),
                bankAccountDTO.getCurrencyType(),
                bankAccountDTO.getBalance()
            );
            
            BankAccount savedAccount = bankService.createAccount(account);
            return ResponseEntity.ok(savedAccount);
            
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{accountId}/deposit")
    public ResponseEntity<String> deposit(@PathVariable Long accountId, @RequestParam BigDecimal amount) {
        try {
            bankService.depositAmount(accountId, amount);
            return ResponseEntity.ok("Amount deposited successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{accountId}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable Long accountId, @RequestParam BigDecimal amount) {
        try {
            bankService.withDraw(accountId, amount);
            return ResponseEntity.ok("Amount withdrawn successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{accountId}/balance")
    public ResponseEntity<String> updateBalance(@PathVariable Long accountId, @RequestParam BigDecimal balance) {
        try {
            bankService.updateBalance(accountId, balance);
            return ResponseEntity.ok("Balance updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{accountId}/currency")
    public ResponseEntity<String> updateCurrency(@PathVariable Long accountId, @RequestParam String currency) {
        try {
            bankService.updateCurrency(accountId, currency);
            return ResponseEntity.ok("Currency updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BankAccount>> getUserAccounts(@PathVariable Long userId) {
        try {
            List<BankAccount> accounts = bankService.getAllAccounts(userId);
            return ResponseEntity.ok(accounts);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountId) {
        try {
            bankService.deleteAccount(accountId);
            return ResponseEntity.ok("Account deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}