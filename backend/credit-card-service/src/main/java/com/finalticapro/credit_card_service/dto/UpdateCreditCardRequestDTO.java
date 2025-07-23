package com.finalticapro.credit_card_service.dto;

import java.time.LocalDate;

public class UpdateCreditCardRequestDTO {
	
	private String cardName;
	private String cardType;
	private String issuer;
	private Double creditLimit;
	private Double totalSpent;
	private LocalDate billingDate;
	private LocalDate expiryDate;
	private String cardNumber;
			
	public UpdateCreditCardRequestDTO()
	{
		
	}
	
	

	public UpdateCreditCardRequestDTO(String cardName, String cardType, String issuer, Double creditLimit,
			Double totalSpent, LocalDate billingDate, LocalDate expiryDate, String cardNumber) {
		super();
		this.cardName = cardName;
		this.cardType = cardType;
		this.issuer = issuer;
		this.creditLimit = creditLimit;
		this.totalSpent = totalSpent;
		this.billingDate = billingDate;
		this.expiryDate = expiryDate;
		this.cardNumber = cardNumber;
	}



	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public Double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Double getTotalSpent() {
		return totalSpent;
	}

	public void setTotalSpent(Double totalSpent) {
		this.totalSpent = totalSpent;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "UpdateCreditCardRequestDTO [cardName=" + cardName + ", cardType=" + cardType + ", issuer=" + issuer
				+ ", creditLimit=" + creditLimit + ", totalSpent=" + totalSpent + ", billingDate=" + billingDate
				+ ", expiryDate=" + expiryDate + ", cardNumber=" + cardNumber + "]";
	}
	
	
	
}
