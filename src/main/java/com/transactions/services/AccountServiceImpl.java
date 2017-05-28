package com.transactions.services;

import com.transactions.model.Account;
import com.transactions.model.Transaction;
import com.transactions.repository.AccountReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountReposiroty accountReposiroty;

    @Autowired
    TransactionService transactionService;

    public Account getAccount() {
        Account account = accountReposiroty.findOne((long) 1);
        return account;
    }

// create default account
    public void addAccount() {
        Account account = new Account();

        account.setId((long) 1);
        account.setAccountBalance(BigDecimal.valueOf(1000));
        account.setAccountNumber(123565);

        accountReposiroty.save(account);
    }


    public void deposit(double amount) {



        Account account = accountReposiroty.findOne((long) 1);
        account.setAccountBalance(account.getAccountBalance().add(new BigDecimal(amount)));
        accountReposiroty.save(account);

        Date date = new Date();

        Transaction transaction = new Transaction(date, "Deposit", "Account", "Finished", amount, account.getAccountBalance(), account);
        transactionService.saveDepositTransaction(transaction);

    }


    public void withdraw(double amount) throws Exception {
        Account account = accountReposiroty.findOne((long) 1);

        account.setAccountBalance(account.getAccountBalance().subtract(new BigDecimal(amount)));

        if( account.getAccountBalance().compareTo(BigDecimal.ZERO) < 0 ) throw new Exception("Balance can not be negative");

        accountReposiroty.save(account);

        Date date = new Date();

        Transaction transaction = new Transaction(date, "Withdraw", "Account", "Finished", amount, account.getAccountBalance(), account);
        transactionService.saveWithdrawTransaction(transaction);
    }
}
