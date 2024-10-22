package com.example.wallet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDate;
import java.util.Collection;
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
    private LocalDate birthDate;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Enumerated(EnumType.ORDINAL)
    private MilitaryStatus militaryStatus;

    @Email(message = "ایمیل معتبر وارد کنید.")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "ورود رمز عبور الرامی است.")
    @Size(min = 8,max = 16,message = "رمز عبور باید باید بین ۸ و ۱۶ رقم باشد.")
    private String password;

    public Person(){}

    public Person(long id, String mobileNumber, String nationalId, String firstName, String lastName, LocalDate birthDate, Gender gender, MilitaryStatus militaryStatus, String email, String password) {
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.nationalId = nationalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.militaryStatus = militaryStatus;
        this.email = email;
        this.password = password;
    }

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MilitaryStatus getMilitaryStatus() {
        return militaryStatus;
    }

    public void setMilitaryStatus(MilitaryStatus militaryStatus) {
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

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
