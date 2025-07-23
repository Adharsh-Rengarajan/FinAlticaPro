package com.finalticapro.credit_card_service.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finalticapro.credit_card_service.model.CreditCard;

import jakarta.transaction.Transactional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
	List<CreditCard> findByUserId(Long userId);
	Optional<CreditCard> findByCardNumber(String cardNumber);
	Optional<CreditCard> findByCardId(Long id);
	boolean existsByCardId(Long id);
	boolean existsByCardNumber(String id);
	
    int deleteByCardId(Long cardId);
}
