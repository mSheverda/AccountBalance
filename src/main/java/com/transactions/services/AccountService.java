package com.transactions.services;

import com.transactions.model.Account;
import org.springframework.stereotype.Service;

@Service
public interface  AccountService {
    Account getAccount();

    void deposit(double amount);

    void withdraw(double amount) throws Exception;

     void addAccount();
}
