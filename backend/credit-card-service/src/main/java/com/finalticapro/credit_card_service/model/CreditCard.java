package com.finalticapro.credit_card_service.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="credit_cards")


public class CreditCard {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cardId;
	
	private String cardName;
	private String cardType;
	private String issuer;
	private Double creditLimit;
	private Double totalSpent;
	private LocalDate billingDate;
	private LocalDate expiryDate;
	private String cardNumber;
		
	private Long userId;
	
	public CreditCard()
	{
		
	}

	public CreditCard(Long cardId, String cardName, String cardType, String issuer, Double creditLimit,
			Double totalSpent, LocalDate billingDate, LocalDate expiryDate, String cardNumber, Long userId) {
		super();
		this.cardId = cardId;
		this.cardName = cardName;
		this.cardType = cardType;
		this.issuer = issuer;
		this.creditLimit = creditLimit;
		this.totalSpent = totalSpent;
		this.billingDate = billingDate;
		this.expiryDate = expiryDate;
		this.cardNumber = cardNumber;
		this.userId = userId;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CreditCard [cardId=" + cardId + ", cardName=" + cardName + ", cardType=" + cardType + ", issuer="
				+ issuer + ", creditLimit=" + creditLimit + ", totalSpent=" + totalSpent + ", billingDate="
				+ billingDate + ", expiryDate=" + expiryDate + ", cardNumber=" + cardNumber + ", userId=" + userId
				+ "]";
	}

	
	
}
