package com.tcs.mmisamples.customerprofile.service.impl;

import com.tcs.mmisamples.customerprofile.dao.CustomerProfilePaginationRepository;
import com.tcs.mmisamples.customerprofile.dao.CustomerProfileRepository;
import com.tcs.mmisamples.customerprofile.domain.CustomerProfile;
import com.tcs.mmisamples.customerprofile.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by SSasidharan on 2016/12/26.
 */
@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    @Autowired
    CustomerProfileRepository customerProfileRepository;

    @Autowired
    CustomerProfilePaginationRepository customerProfilePaginationRepository;

    public CustomerProfileServiceImpl() {

    }

    @PostConstruct
    public void loadData() {
        CustomerProfile customerProfile = null;
        for (int i=0 ; i < 100; i++) {
            customerProfile = new CustomerProfile("Test : " + i%5, ((Integer)i).toString());
            saveCustomerProfile(customerProfile);
        }
    }

    public Iterable<CustomerProfile> findAllCustomerProfiles() {
        return customerProfileRepository.findAll();
    }

    public CustomerProfile saveCustomerProfile(CustomerProfile customerProfile) {
        return customerProfileRepository.save(customerProfile);
    }

    @Override
    public Page<CustomerProfile> findCustomerProfileByName(String name, Pageable pageable) {
        return customerProfilePaginationRepository.findCustomerProfileByName(name, pageable);
    }

}
