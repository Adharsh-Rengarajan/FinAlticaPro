package com.finalticapro.application.entities.account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.finalticapro.application.entities.user.User;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(name = "bank_name", nullable = false, length = 100)
    private String bankName;
    
    @Column(name = "account_type", nullable = false, length = 20)
    private String accountType;
    
    @Column(name = "account_number", nullable = false, length = 50)
    private String accountNumber;
    
    @Column(name = "balance", precision = 15, scale = 2, nullable = false)
    private BigDecimal balance;
    
    @Column(name = "currency_type", nullable = false, length = 3)
    private String currencyType;
    

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    public BankAccount() {}
    
    public BankAccount(User user, String bankName, String accountType, String accountNumber, String currencyType, BigDecimal balance) {
        this.user = user;
        this.bankName = bankName;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.currencyType = currencyType;
        this.balance = balance;
    }

    
    // Getters and Setters
    public Long getAccountId() {
        return accountId;
    }
    
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getBankName() {
        return bankName;
    }
    
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public BigDecimal getBalance() {
        return balance;
    }
    
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
    public String getCurrencyType() {
        return currencyType;
    }
    
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }
    
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    @Override
    public String toString() {
        return "BankAccount [accountId=" + accountId + ", bankName=" + bankName
                + ", accountType=" + accountType + ", accountNumber=" + accountNumber 
                + ", balance=" + balance + ", currencyType=" + currencyType 
                +"]";
    }
}