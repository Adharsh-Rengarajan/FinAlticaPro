package com.finalticapro.application.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finalticapro.application.entities.account.CreditCardAccount;

import jakarta.transaction.Transactional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardAccount, Long>{

	List<CreditCardAccount> findByUserUserId(long id);
	
	boolean existsByUserUserIdAndCardNameAndAccountType(Long userId, String cardName, String accountType);
    
    @Modifying
    @Transactional
    @Query("UPDATE credit_card_account c SET c.current_balance = :balance WHERE c.credit_card_id = :accountId")
    int updateBalance(@Param("accountId") Long accountId, @Param("balance") BigDecimal balance);
    
    @Modifying
    @Transactional
    @Query("UPDATE credit_card_account c SET b.currency_type = :currency WHERE c.accountId = :accountId")
    int updateCurrencyType(@Param("accountId") Long accountId, @Param("currency") String currency);
    
    
    @Modifying
    @Transactional
    @Query("UPDATE credit_card_account c SET b.total_spent = :amount WHERE c.accountId = :accountId")
    int updateTotalSpent(@Param("accountId") Long accountId, @Param("amount") BigDecimal amount);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM credit_card_account c WHERE c.accountId = :accountId")
    void deleteAccount(@Param("accountId") Long accountId);
}
