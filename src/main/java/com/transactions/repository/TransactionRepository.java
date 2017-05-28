package com.transactions.repository;

import com.transactions.model.Account;
import com.transactions.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}

