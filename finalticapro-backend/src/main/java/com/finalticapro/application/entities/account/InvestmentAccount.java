package com.finalticapro.application.entities.account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.finalticapro.application.entities.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "investment_accounts")
public class InvestmentAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long investmentId;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(name = "broker_name", nullable = false, length = 100)
	private String brokerName;
    
    @Column(name = "total_value_invested", precision = 15, scale = 2, nullable = false)
	private BigDecimal totalValueInvested;
    
    @Column(name = "currency", nullable = false, length = 5)
	private String currency;
	
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
	


	public InvestmentAccount() {}


	public InvestmentAccount(User user, String brokerName, BigDecimal totalValueInvested,
			String currency) {
		super();
		this.investmentId = investmentId;
		this.user = user;
		this.brokerName = brokerName;
		this.totalValueInvested = totalValueInvested;
		this.currency = currency;
	}

	
	public long getInvestmentId() {
		return investmentId;
	}


	public void setInvestmentId(long investmentId) {
		this.investmentId = investmentId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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
		return "InvestmentAccount [investmentId=" + investmentId + ", user=" + user + ", brokerName=" + brokerName
				+ ", totalValueInvested=" + totalValueInvested + ", currency=" + currency + "]";
	}
	
	
}
