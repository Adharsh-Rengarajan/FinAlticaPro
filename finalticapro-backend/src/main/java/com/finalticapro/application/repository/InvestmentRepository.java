package com.finalticapro.application.repository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.finalticapro.application.entities.account.InvestmentAccount;
import jakarta.transaction.Transactional;

@Repository
public interface InvestmentRepository extends JpaRepository<InvestmentAccount, Long> {
    List<InvestmentAccount> findByUserUserId(Long userId);
    
    boolean existsByUserUserIdAndBrokerName(Long userId, String brokerName);
    
    @Modifying
    @Transactional
    @Query("UPDATE InvestmentAccount i SET i.currency = :currency WHERE i.investmentId = :accountId")
    int updateCurrencyType(@Param("accountId") Long accountId, @Param("currency") String currency);
    
    @Modifying
    @Transactional
    @Query("UPDATE InvestmentAccount i SET i.totalValueInvested = :totalValueInvested WHERE i.investmentId = :accountId")
    int updateTotalValueInvested(@Param("accountId") Long accountId, @Param("totalValueInvested") BigDecimal totalValueInvested);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM InvestmentAccount i WHERE i.investmentId = :accountId")
    void deleteAccount(@Param("accountId") Long accountId);
}