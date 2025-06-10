package com.finalticapro.application.dto.accounts;

import java.math.BigDecimal;


public class BankAccountRequestDTO {
	
    private long userId;
    
    private String bankName;
    
    private String accountType;
    
    private String accountNumber;
    
    private BigDecimal balance;
    
    private String currencyType;
    
    public BankAccountRequestDTO() {}
    
    public BankAccountRequestDTO(long userId, String bankName, String accountType, String accountNumber, String currencyType, BigDecimal balance) {
        this.userId = userId;
        this.bankName = bankName;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.currencyType = currencyType;
        this.balance = balance;
    }

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "BankAccountRequestDTO [userId=" + userId + ", bankName=" + bankName + ", accountType=" + accountType
				+ ", accountNumber=" + accountNumber + ", balance=" + balance + ", currencyType=" + currencyType + "]";
	}
    
    
    
}