package com.finalticapro.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalticapro.application.entities.account.CreditCardAccount;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardAccount, Long>{

}
