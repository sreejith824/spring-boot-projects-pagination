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
    private String product;



    @Column(nullable = false)
    private Date startDate;


    @Column(nullable = false)
    private String age;



   @Id
   @GeneratedValue
    private  int id;

    protected CustomerProfile() {
    }

    public CustomerProfile(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
