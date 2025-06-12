package com.finalticapro.application.entities.account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.finalticapro.application.entities.user.User;

import jakarta.persistence.*;

@Entity
@Table(name = "credit_card_accounts")
public class CreditCardAccount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_card_id")
    private Long creditCardId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(name = "card_name", nullable = false, length = 100)
    private String cardName;
    
    @Column(name = "current_balance", precision = 15, scale = 2, nullable = false)
    private BigDecimal currentBalance = BigDecimal.ZERO;
    
    @Column(name = "credit_limit", precision = 15, scale = 2, nullable = false)
    private BigDecimal creditLimit;
    
    @Column(name = "currency", nullable = false, length = 3)
    private String currency;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    

    public CreditCardAccount() {}
    
    public CreditCardAccount(User user, String cardName, BigDecimal creditLimit, String currency) {
        this.user = user;
        this.cardName = cardName;
        this.creditLimit = creditLimit;
        this.currency = currency;
        this.currentBalance = BigDecimal.ZERO;
    }
    
    // Getters and Setters
    public Long getCreditCardId() {
        return creditCardId;
    }
    
    public void setCreditCardId(Long creditCardId) {
        this.creditCardId = creditCardId;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getCardName() {
        return cardName;
    }
    
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }
    
    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }
    
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }
    
    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
    
    
    public String getCurrency() {
        return currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
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
        return "CreditCardAccount [creditCardId=" + creditCardId + ", cardName=" + cardName
                + ", currentBalance=" + currentBalance + ", creditLimit=" + creditLimit 
                +  ", currency=" + currency + "]";
    }
}