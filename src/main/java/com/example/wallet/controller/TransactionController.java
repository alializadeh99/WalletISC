package com.example.wallet.controller;

import com.example.wallet.model.Transaction;
import com.example.wallet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    // Constructor Injection
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // متد برای دریافت تمام تراکنش‌ها
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    // متد برای دریافت یک تراکنش بر اساس ID
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Optional<Transaction> transaction = transactionService.getTransactionById(id);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // متد برای دریافت تمام تراکنش‌های یک حساب خاص
    @GetMapping("/account/{accountId}")
    public List<Transaction> getTransactionsByAccountId(@PathVariable Long accountId) {
        return transactionService.getTransactionsByAccountId(accountId);
    }

    // متد برای ایجاد یک تراکنش جدید
    @PostMapping("/account/{accountId}")
    public ResponseEntity<Transaction> createTransaction(@PathVariable Long accountId, @RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.createTransaction(accountId, transaction));
    }

}
