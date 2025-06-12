package com.finalticapro.application.controllers.account;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalticapro.application.dto.accounts.CreditCardAccountRequestDTO;
import com.finalticapro.application.dto.accounts.InvestmentAccountRequestDTO;
import com.finalticapro.application.entities.account.CreditCardAccount;
import com.finalticapro.application.entities.account.InvestmentAccount;
import com.finalticapro.application.entities.user.User;
import com.finalticapro.application.services.UserService;
import com.finalticapro.application.services.account.CreditCardService;
import com.finalticapro.application.services.account.InvestmentService;

@RestController
@RequestMapping("/investment")
public class InvestmentController {

	@Autowired
	private InvestmentService investmentService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<InvestmentAccount> createAccount(@RequestBody  InvestmentAccountRequestDTO account)
	{
		try {
			User user = userService.findById(account.getUserId());
			InvestmentAccount investmentAccount=new InvestmentAccount(
					user,
					account.getBrokerName(),
					account.getTotalValueInvested(),
					account.getCurrency());
			InvestmentAccount savedAccount=investmentService.createAccount(investmentAccount);
			return ResponseEntity.ok(savedAccount);
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	
	@GetMapping("/accounts/get/{userId}")
	public ResponseEntity<List<CreditCardAccount>> getAllAccount(@PathVariable Long userId)
	{
		try {
			List<CreditCardAccount> creditCardAccounts=investmentService.getAllAccounts(userId);
			return ResponseEntity.ok(creditCardAccounts);
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("accounts/{accountId}/update/balance")
	public ResponseEntity<String> updateBalance(@PathVariable Long accountId,  @RequestBody Map<String, BigDecimal> request )
	{
		
		
		try {
			investmentService.updateBalance(accountId, request.get("balance"));
			return ResponseEntity.ok("Balance updated succesfully");
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	
	@PutMapping("accounts/{accountId}/update/currency")
	public ResponseEntity<String> updateCurrency(@PathVariable Long accountId,  @RequestBody Map<String, String> request )
	{
		
		
		try {
			investmentService.updateCurrency(accountId, request.get("currency"));
			return ResponseEntity.ok("Currency updated succesfully");
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	
	
	@DeleteMapping("/accounts/delete/{accountId}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long accountId)
	{
		try
		{
			investmentService.deleteAccount(accountId);
			return ResponseEntity.ok("Account Succesfully deleted");
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().build();
		}
	}
	
}
