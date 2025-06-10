package com.finalticapro.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalticapro.application.entities.account.BankAccount;

@Repository
public interface BankRepository extends JpaRepository<BankAccount, Long>{

}
