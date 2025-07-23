package com.finalticapro.credit_card_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalticapro.credit_card_service.dto.UpdateCreditCardRequestDTO;
import com.finalticapro.credit_card_service.dto.ValidateCardRequestDTO;
import com.finalticapro.credit_card_service.model.CreditCard;
import com.finalticapro.credit_card_service.repository.CreditCardRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditCardService {
	
	@Autowired
	private CreditCardRepository repository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Transactional
	public ResponseEntity<CreditCard> createCard(JsonNode jsonCard) throws JsonProcessingException, IllegalArgumentException
	{
			JsonNode cardNumber=jsonCard.get("cardNumber");
			String id=cardNumber.asText();
			if(repository.existsByCardNumber(id))
			{
				return ResponseEntity.badRequest().build();
			}
			else
			{
				CreditCard creditCard = objectMapper.treeToValue(jsonCard, CreditCard.class);
				CreditCard savedCard=repository.save(creditCard);
				return ResponseEntity.ok(savedCard);
			}
		
	}
	
	@Transactional(readOnly = true)
	public ResponseEntity<CreditCard> getCard(Long id)
	{
	    Optional<CreditCard> optionalCard = repository.findByCardId(id);

	    if (optionalCard.isPresent()) {
	        return ResponseEntity.ok(optionalCard.get());
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
	
	@Transactional
	public ResponseEntity<CreditCard> updateCard(Long id, UpdateCreditCardRequestDTO dto) {
	    Optional<CreditCard> optionalCard = repository.findByCardId(id);

	    if (optionalCard.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }

	    CreditCard card = optionalCard.get();

	    if (dto.getCardName() != null) card.setCardName(dto.getCardName());
	    if (dto.getCardType() != null) card.setCardType(dto.getCardType());
	    if (dto.getIssuer() != null) card.setIssuer(dto.getIssuer());
	    if (dto.getCreditLimit() != null) card.setCreditLimit(dto.getCreditLimit());
	    if (dto.getBillingDate() != null) card.setBillingDate(dto.getBillingDate());
	    if (dto.getExpiryDate() != null) card.setExpiryDate(dto.getExpiryDate());
	    if (dto.getCardNumber() != null) card.setCardNumber(dto.getCardNumber());
	    if (dto.getTotalSpent()!= null) card.setTotalSpent(dto.getTotalSpent());

	    CreditCard updatedCard = repository.save(card);
	    return ResponseEntity.ok(updatedCard);
	}

	@Transactional
	public ResponseEntity<Boolean> validateTransaction(ValidateCardRequestDTO request) throws Exception
	{
		Long cardId=request.getCardId();
		Long userId=request.getUserId();
		Double amount=request.getAmount();
		Optional<CreditCard> card=repository.findByCardId(cardId);
		if(card.isPresent())
		{
			CreditCard creditCard=card.get();
			double limit=creditCard.getCreditLimit();
			//Need to get the netOutStanding from transactions table for now keeping it 0
			double netOutStanding=0;
			boolean isValid = netOutStanding + amount <= limit;
			return ResponseEntity.ok(isValid);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
		}
	}
	
	@Transactional
	public ResponseEntity<Boolean> deleteCard(Long id)
	{
		int del=repository.deleteByCardId(id);
		if(del>0)
		{
			return ResponseEntity.ok(true);
		}
		else
		{
			return ResponseEntity.ok(false);
		}
	}
	
}
