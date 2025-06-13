package com.finalticapro.application.dto.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionRequestDTO {
	

    
    private Long userId;
    private BigDecimal amount;
    private String transactionType;
    private String paymentMethodType;
    private Long paymentMethodId;
    private Long linkedAccountId;
    private String description; 
    private String fromAccount;
    private String toAccount;
    private String currency;
    private boolean isRecurring;
    private LocalDateTime transactionDate;
    
    
    TransactionRequestDTO() {}
    
    
    
	public TransactionRequestDTO(Long userId, BigDecimal amount, String transactionType, String paymentMethodType,
			Long paymentMethodId, Long linkedAccountId, String description, String fromAccount, String toAccount,
			String currency, boolean isRecurring, LocalDateTime transactionDate) {
		super();
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
		return "TransactionRequestDTO [userId=" + userId + ", amount=" + amount + ", transactionType=" + transactionType
				+ ", paymentMethodType=" + paymentMethodType + ", paymentMethodId=" + paymentMethodId
				+ ", linkedAccountId=" + linkedAccountId + ", description=" + description + ", fromAccount="
				+ fromAccount + ", toAccount=" + toAccount + ", currency=" + currency + ", isRecurring=" + isRecurring
				+ ", transactionDate=" + transactionDate + "]";
	}

    
    
}
