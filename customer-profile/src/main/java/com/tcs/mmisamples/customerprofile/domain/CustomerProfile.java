package com.tcs.mmisamples.customerprofile.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by SSasidharan on 2016/12/26.
 */

@Entity
public class CustomerProfile {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column
    private String email;



   @Id
   @GeneratedValue
    private  int customerId;

    protected CustomerProfile() {
    }

    public CustomerProfile(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public CustomerProfile(int id) {
        this.customerId = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
