package com.transactions.services;

import com.transactions.model.Account;
import com.transactions.model.Transaction;
import com.transactions.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    AccountService accountService;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findTransactionList(int accountId) {
        Account account = accountService.getAccount();
        List<Transaction> transactionList = account.getTransactionList();
        return transactionList;
    }

    @Override
    @Transactional
    public void saveDepositTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    @Transactional
    public void saveWithdrawTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

}
