package com.finalticapro.credit_card_service.dto;

public class ValidateCardRequestDTO {
	private Long cardId;
	private Long userId;
	private Double amount;
	
	public ValidateCardRequestDTO()
	{
		
	}
	
	public ValidateCardRequestDTO(Long cardId, Long userId, Double amount) {
		super();
		this.cardId = cardId;
		this.userId = userId;
		this.amount = amount;
	}
	public Long getCardId() {
		return cardId;
	}
	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "ValidateCardRequestDTO [cardId=" + cardId + ", userId=" + userId + ", amount=" + amount + "]";
	}
	
	
}
