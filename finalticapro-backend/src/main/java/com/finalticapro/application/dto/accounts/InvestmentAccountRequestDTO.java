package com.finalticapro.application.dto.accounts;

import java.math.BigDecimal;

public class InvestmentAccountRequestDTO {

	private Long userId;
	private String brokerName;
	private BigDecimal totalValueInvested;
	private String currency;
	
	InvestmentAccountRequestDTO(){}

	public InvestmentAccountRequestDTO(Long userId, String brokerName, BigDecimal totalValueInvested, String currency) {
		super();
		this.userId = userId;
		this.brokerName = brokerName;
		this.totalValueInvested = totalValueInvested;
		this.currency = currency;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserIdl(Long userIdl) {
		this.userId = userIdl;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public BigDecimal getTotalValueInvested() {
		return totalValueInvested;
	}

	public void setTotalValueInvested(BigDecimal totalValueInvested) {
		this.totalValueInvested = totalValueInvested;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}