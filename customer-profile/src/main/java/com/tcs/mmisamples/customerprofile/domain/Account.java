package com.tcs.mmisamples.customerprofile.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SSasidharan on 2016/12/26.
 */

@Entity
public class Account {

    @ManyToOne
    @JoinColumn(name= "customerId")
    private CustomerProfile customerProfile;

    @Column(nullable = false)
    private String accountType;

    @Column
    private Double balance;

    @Column(nullable = false)
    private String accountStatus;

   @Id
   @GeneratedValue
    private  int accountId;

    protected Account() {
    }

    public Account(CustomerProfile customerProfile,String accountType) {
        this.customerProfile = customerProfile;

        this.accountType = accountType;
    }



    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }

}
