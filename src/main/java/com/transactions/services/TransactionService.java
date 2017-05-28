package com.transactions.services;

import com.transactions.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    List<Transaction> findTransactionList(int accountId);

    void saveDepositTransaction(Transaction primaryTransaction);

    void saveWithdrawTransaction(Transaction primaryTransaction);

}
