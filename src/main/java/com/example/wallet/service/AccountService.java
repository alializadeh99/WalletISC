package com.example.wallet.service;

import com.example.wallet.model.Account;
import com.example.wallet.repository.AccountRepository;
import com.example.wallet.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id){
        return accountRepository.findById(id);
    }

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }

    public Account updateAccount(Long id,Account updatedAccount){
        Optional<Account> existingAccountOptional=accountRepository.findById(id);

        if (existingAccountOptional.isPresent()){
            Account existingAccount=existingAccountOptional.get();

            existingAccount.setBalance(updatedAccount.getBalance());

            return accountRepository.save(existingAccount);
        }
        else {
            throw new RuntimeException("حسابی با این شناسه یافت نشد:"+id);
        }
    }

}
