package com.transactions.repository;

import com.transactions.model.Account;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface AccountReposiroty extends JpaRepository<Account, Long> {
}