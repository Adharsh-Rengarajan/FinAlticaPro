package com.finalticapro.application.services.account;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalticapro.application.entities.account.CreditCardAccount;
import com.finalticapro.application.repository.CreditCardRepository;

@Service
public class CreditCardService {

	@Autowired
	public CreditCardRepository creditCardRepository;
	
	public CreditCardAccount createAccount(CreditCardAccount account)
	{
		if(account==null || account.getUser()==null)
		{
			throw new IllegalArgumentException("Account or User cannot be null");
		}
		
		boolean accountExists = creditCardRepository.existsByUserUserIdAndCardName(
				account.getUser().getUserId(), account.getCardName(), account.getCurrency()
				);
		
		if(accountExists)
		{
			throw new RuntimeException("Account already exists");
		}
		
		return creditCardRepository.save(account);
	}
	
	
	public void updateBalance(Long accountId, BigDecimal amount) {
        creditCardRepository.updateBalance(accountId, amount);
    }
    
    public void updateCurrency(Long accountId, String currency) {
    	creditCardRepository.updateCurrencyType(accountId, currency);
    }
    
    public List<CreditCardAccount> getAllAccounts(Long userId) {
        return creditCardRepository.findByUserUserId(userId); 
    }
    
    public void deleteAccount(Long accountId) {
        if (!creditCardRepository.existsById(accountId)) {
            throw new RuntimeException("Account not found");
        }
        creditCardRepository.deleteAccount(accountId);
    }
}
