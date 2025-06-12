package com.finalticapro.application.dto.accounts;

import java.math.BigDecimal;

public class CreditCardAccountRequestDTO {

	private long userId;
    private String cardName;
    private BigDecimal currentBalance;
    private BigDecimal creditLimit;
    private String currency;
    
    
    
	public CreditCardAccountRequestDTO(long userId, String cardName, BigDecimal currentBalance, BigDecimal creditLimit,
			String currency) {
		super();
		this.userId = userId;
		this.cardName = cardName;
		this.currentBalance = currentBalance;
		this.creditLimit = creditLimit;
		this.currency = currency;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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

	
}
