package com.example.wallet.dtos;

import jakarta.validation.constraints.*;

import java.util.Date;

public class RegisterUserDto {

    @NotBlank(message = "ورود موبایل الرامی است.")
    @Pattern(regexp = "\\d{11}",message = "شماره موبایل صحبح نیست.")
    private String mobileNumber;

    @NotBlank(message = "ورود کد ملی الزامی است.")
    @Pattern(regexp = "\\d{10}",message = "کد ملی صحبح نیست.")
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
    private String email;

    @NotBlank(message = "ورود رمز عبور الرامی است.")
    @Size(min = 8,max = 16,message = "رمز عبور باید باید بین ۸ و ۱۶ رقم باشد.")
    private String password;

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

    public Date getBirthDate() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
