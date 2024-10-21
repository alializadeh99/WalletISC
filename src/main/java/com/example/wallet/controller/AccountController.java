package com.example.wallet.controller;


import com.example.wallet.model.Account;
import com.example.wallet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    // Constructor Injection
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // متد برای دریافت همه حساب‌ها
//    @GetMapping
//    public List<Account> getAllAccounts() {
//        return accountService.getAllAccounts();
//    }

    // متد برای دریافت یک حساب بر اساس ID
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Optional<Account> account = accountService.getAccountById(id);
        return account.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // متد برای ایجاد حساب جدید
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    // متد برای به‌روزرسانی حساب
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account updatedAccount) {
        return ResponseEntity.ok(accountService.updateAccount(id, updatedAccount));
    }

    // متد برای حذف حساب بر اساس ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
