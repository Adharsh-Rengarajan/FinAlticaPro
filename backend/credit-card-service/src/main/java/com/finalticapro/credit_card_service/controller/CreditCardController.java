package com.finalticapro.credit_card_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.finalticapro.credit_card_service.dto.UpdateCreditCardRequestDTO;
import com.finalticapro.credit_card_service.dto.ValidateCardRequestDTO;
import com.finalticapro.credit_card_service.model.CreditCard;
import com.finalticapro.credit_card_service.service.CreditCardService;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {
	
	@Autowired
	private CreditCardService service;
	
	@PostMapping("/create")
	public ResponseEntity<CreditCard> createCard(@RequestBody JsonNode data) throws JsonProcessingException, IllegalArgumentException
	{
		return service.createCard(data);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CreditCard> getCard(@PathVariable Long id)
	{
		return service.getCard(id);
	}
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<CreditCard> updateCard(@RequestBody UpdateCreditCardRequestDTO card, @PathVariable Long id) throws Exception
	{
		return service.updateCard(id, card);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteCard(@PathVariable Long id)
	{
		return service.deleteCard(id);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<Boolean> validate(@RequestBody ValidateCardRequestDTO validateRequest) throws Exception 
	{
		return service.validateTransaction(validateRequest);
	}
	
	
}
