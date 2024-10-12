package com.example.wallet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Date;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "ورود شماره حساب الزامی است.")
    private String accountNumber;

    @Min(value = 10000, message = "حداقل موجودی باید 10000 ریال باشد")
    private double balance;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @NotBlank(message = "ورود شماره شبا الزامی است")
    private String iban;

    // ارتباط بین حساب و شخص
    @ManyToOne  // چندین حساب می‌تواند به یک شخص تعلق بگیرد
    private Person owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
