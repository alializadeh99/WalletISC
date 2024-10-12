package com.example.wallet.repository;


import com.example.wallet.model.Account;
import com.example.wallet.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findByAccount(Account account);
}
