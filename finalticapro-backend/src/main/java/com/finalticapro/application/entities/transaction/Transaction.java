package com.finalticapro.application.entities.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;
    
    @Column(name = "user_id", nullable = false)
    private Long userId;
    
    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;
    
    @Column(name = "transaction_type", nullable = false)
    private String transactionType;
    
    @Column(name = "payment_method_type", nullable = false)
    private String paymentMethodType;
    
    @Column(name = "payment_method_id")
    private Long paymentMethodId;
    
    @Column(name = "linked_account_id")
    private Long linkedAccountId;
    
    
    @Column(name = "description")
    private String description; 
    
    @Column(name = "from_account")
    private String fromAccount;
    
    @Column(name = "to_account")
    private String toAccount;
    
    @Column(name = "currency")
    private String currency;
    
    @Column(name = "is_recurring")
    private boolean isRecurring;
    
    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;
    
    public Transaction() {}
    
    public Transaction(Long transactionId, Long userId, BigDecimal amount, String transactionType, 
                      String paymentMethodType, Long paymentMethodId, Long linkedAccountId, 
                      String description, String fromAccount, String toAccount, 
                      String currency, boolean isRecurring, LocalDateTime transactionDate) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.paymentMethodType = paymentMethodType;
        this.paymentMethodId = paymentMethodId;
        this.linkedAccountId = linkedAccountId;
        this.description = description;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.currency = currency;
        this.isRecurring = isRecurring;
        this.transactionDate = transactionDate;
    }
    
    public Long getTransactionId() {
        return transactionId;
    }
    
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public String getTransactionType() {
        return transactionType;
    }
    
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    
    public String getPaymentMethodType() {
        return paymentMethodType;
    }
    
    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }
    
    public Long getPaymentMethodId() {
        return paymentMethodId;
    }
    
    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
    
    public Long getLinkedAccountId() {
        return linkedAccountId;
    }
    
    public void setLinkedAccountId(Long linkedAccountId) {
        this.linkedAccountId = linkedAccountId;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getFromAccount() {
        return fromAccount;
    }
    
    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }
    
    public String getToAccount() {
        return toAccount;
    }
    
    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public boolean isRecurring() {
        return isRecurring;
    }
    
    public void setRecurring(boolean isRecurring) {
        this.isRecurring = isRecurring;
    }
    
    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }
    
    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", userId=" + userId + ", amount=" + amount
				+ ", transactionType=" + transactionType + ", paymentMethodType=" + paymentMethodType
				+ ", paymentMethodId=" + paymentMethodId + ", linkedAccountId=" + linkedAccountId + ", description="
				+ description + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", currency=" + currency
				+ ", isRecurring=" + isRecurring + ", transactionDate=" + transactionDate + "]";
	}
    
    
}