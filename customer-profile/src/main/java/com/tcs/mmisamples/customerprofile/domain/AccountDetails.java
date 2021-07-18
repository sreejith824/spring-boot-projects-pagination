package com.tcs.mmisamples.customerprofile.domain;

public class AccountDetails {

    private String name;
    private int age;
    private int customerId;
    private int accountId;
    private String accountType;
    private String accountStatus;

    public AccountDetails(String name, int age, int customerId, int accountId, String accountType, String accountStatus) {
        this.name = name;
        this.age = age;
        this.customerId = customerId;
        this.accountId = accountId;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
