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
    
    boolean existsByUserUserIdAndCardName(Long userId, String cardName, String accountType);
    
    @Modifying
    @Transactional
    @Query("UPDATE CreditCardAccount c SET c.currentBalance = :balance WHERE c.creditCardId = :accountId")
    int updateBalance(@Param("accountId") Long accountId, @Param("balance") BigDecimal balance);
    
    @Modifying
    @Transactional
    @Query("UPDATE CreditCardAccount c SET c.currency = :currency WHERE c.creditCardId = :accountId")
    int updateCurrencyType(@Param("accountId") Long accountId, @Param("currency") String currency);
    
    @Modifying
    @Transactional
    @Query("UPDATE CreditCardAccount c SET c.totalSpent = :amount WHERE c.creditCardId = :accountId")
    int updateTotalSpent(@Param("accountId") Long accountId, @Param("amount") BigDecimal amount);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM CreditCardAccount c WHERE c.creditCardId = :accountId")
    void deleteAccount(@Param("accountId") Long accountId);
}