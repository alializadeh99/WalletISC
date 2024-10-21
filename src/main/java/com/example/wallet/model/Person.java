package com.example.wallet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
public class Person implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "ورود موبایل الرامی است.")
    @Pattern(regexp = "\\d{11}",message = "شماره موبایل صحبح نیست.")
    @Column(unique = true)
    private String mobileNumber;

    @NotBlank(message = "ورود کد ملی الزامی است.")
    @Pattern(regexp = "\\d{10}",message = "کد ملی صحبح نیست.")
    @Column(unique = true)
    private String nationalId;
    @NotBlank(message = "ورود نام الزامی است.")
    private String firstName;

    @NotBlank(message = "ورود نام خانوادگی الزامی است.")
    private String lastName;

    @Past(message = "تاریخ تولد باید برای گدشته باشد.")
    private Date birthDate;

    private String gender;

    private String militaryStatus;

    @Email(message = "ایمیل معتبر وارد کنید.")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "ورود رمز عبور الرامی است.")
    @Size(min = 8,max = 16,message = "رمز عبور باید باید بین ۸ و ۱۶ رقم باشد.")
    private String password;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public @Past(message = "تاریخ تولد باید برای گدشته باشد.") Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMilitaryStatus() {
        return militaryStatus;
    }

    public void setMilitaryStatus(String militaryStatus) {
        this.militaryStatus = militaryStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nationalId;
    }
}
