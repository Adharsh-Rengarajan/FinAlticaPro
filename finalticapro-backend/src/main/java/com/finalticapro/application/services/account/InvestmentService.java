package com.finalticapro.application.services.account;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalticapro.application.entities.account.CreditCardAccount;
import com.finalticapro.application.entities.account.InvestmentAccount;
import com.finalticapro.application.repository.InvestmentRepository;

@Service
public class InvestmentService {

	@Autowired
	private InvestmentRepository investmentRepository;
	
	
	public InvestmentAccount createAccount(InvestmentAccount account)
	{
		if(account==null || account.getUser()==null)
		{
			throw new IllegalArgumentException("Account or User cannot be null");
		}
		
		boolean accountExists = investmentRepository.existsByUserUserIdAndBrokerName(
				account.getUser().getUserId(), account.getBrokerName()	);
		
		if(accountExists)
		{
			throw new RuntimeException("Account already exists");
		}
		
		return investmentRepository.save(account);
	}	
	
	public void updateTotalValueInvested(Long id, BigDecimal amount)
	{
		investmentRepository.updateTotalValueInvested(id, amount);
	}
	
	public void updateCurrency(Long id, String currency)
	{
		investmentRepository.updateCurrencyType(id, currency);
	}
	
	
	public void deleteAccount(Long id)
	{
		investmentRepository.deleteAccount(id);
	}
	
    public List<InvestmentAccount> getAllAccounts(Long userId) {
        return investmentRepository.findByUserUserId(userId); 
    }
    
	
	
}
