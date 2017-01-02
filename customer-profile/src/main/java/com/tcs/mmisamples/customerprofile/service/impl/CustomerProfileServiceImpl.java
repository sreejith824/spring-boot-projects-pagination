package com.tcs.mmisamples.customerprofile.service.impl;

import com.tcs.mmisamples.customerprofile.dao.CustomerProfilePaginationRepository;
import com.tcs.mmisamples.customerprofile.domain.CustomerProfile;
import com.tcs.mmisamples.customerprofile.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * Created by SSasidharan on 2016/12/26.
 * Spring Service implementation class for Customer profile module.
 */
@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    @Autowired
    CustomerProfilePaginationRepository customerProfilePaginationRepository;

    public CustomerProfileServiceImpl() {

    }

    @PostConstruct
    public void loadData() {
        CustomerProfile customerProfile = null;
        for (int i=0 ; i < 1000; i++) {
            customerProfile = new CustomerProfile("Test : " + i, ((Integer)i).toString());
            customerProfile.setProduct("Product : " + i%5);
            customerProfile.setStartDate(new Date());
            saveCustomerProfile(customerProfile);
        }
    }

    @Override
    public Iterable<CustomerProfile> findAllCustomerProfiles(Pageable pageable) {
        return customerProfilePaginationRepository.findAll(pageable);
    }

    @Override
    public CustomerProfile saveCustomerProfile(CustomerProfile customerProfile) {
        return customerProfilePaginationRepository.save(customerProfile);
    }

    @Override
    public Page<CustomerProfile> findCustomerProfileByName(String name, Pageable pageable) {
        return customerProfilePaginationRepository.findCustomerProfileByName(name, pageable);
    }

}
