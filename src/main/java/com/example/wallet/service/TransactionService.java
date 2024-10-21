package com.example.wallet.service;

import com.example.wallet.model.Account;
import com.example.wallet.model.Transaction;
import com.example.wallet.repository.AccountRepository;
import com.example.wallet.repository.PersonRepository;
import com.example.wallet.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id){
        return transactionRepository.findById(id);
    }

    public Transaction createTransaction(Long accountId,Transaction transaction){
        Optional<Account> existingAccountOptional=accountRepository.findById(accountId);
        if(existingAccountOptional.isPresent()){
            Account account=existingAccountOptional.get();

                if(transaction.getType().equalsIgnoreCase("Deposit")){
                    account.setBalance(account.getBalance()+transaction.getAmount());
                } else if (transaction.getType().equalsIgnoreCase("Withraw")) {
                    if (account.getBalance() >= transaction.getAmount()) {
                        account.setBalance((account.getBalance() - transaction.getAmount()));
                    } else {
                        throw new RuntimeException("موجودی حساب کافی نیست.");
                    }
                }
                    else {
                        throw new RuntimeException("تراکنش باید از نوع واریز یا برداشت باشد.");
                    }
            accountRepository.save(account);// ذخیره‌سازی تراکنش

            transaction.setAccount(account);  // اختصاص حساب به تراکنش
            transaction.setTransactionDate(new Date());  // تعیین تاریخ تراکنش
            return transactionRepository.save(transaction);  // ذخیره تراکنش
        } else {
            throw new RuntimeException("حسابی با این شناسه یافت نشد: " + accountId);
            }
    }

    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        Optional<Account> existingAccountOptional = accountRepository.findById(accountId);

        if (existingAccountOptional.isPresent()) {
            Account account = existingAccountOptional.get();
            return transactionRepository.findByAccount(account);
        } else {
            throw new RuntimeException("اکانتی با این شناسه یافت نشد: " + accountId);
        }
    }
}



