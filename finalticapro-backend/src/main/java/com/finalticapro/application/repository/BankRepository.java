package com.finalticapro.application.repository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.finalticapro.application.entities.account.BankAccount;
import jakarta.transaction.Transactional;

@Repository
public interface BankRepository extends JpaRepository<BankAccount, Long> {
    
    List<BankAccount> findByUserUserId(Long userId);
    
    boolean existsByUserUserIdAndBankNameAndAccountType(Long userId, String bankName, String accountType);
    
    @Modifying
    @Transactional
    @Query("UPDATE BankAccount b SET b.balance = :balance WHERE b.accountId = :accountId")
    int updateBalance(@Param("accountId") Long accountId, @Param("balance") BigDecimal balance);
    
    @Modifying
    @Transactional
    @Query("UPDATE BankAccount b SET b.currencyType = :currency WHERE b.accountId = :accountId")
    int updateCurrencyType(@Param("accountId") Long accountId, @Param("currency") String currency);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM BankAccount b WHERE b.accountId = :accountId")
    void deleteAccount(@Param("accountId") Long accountId);
}