package com.tcs.mmisamples.customerprofile.service;

import com.tcs.mmisamples.customerprofile.domain.CustomerProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by SSasidharan on 2016/12/26.
 */
@Service
public interface CustomerProfileService {
    Iterable<CustomerProfile> findAllCustomerProfiles();
    CustomerProfile saveCustomerProfile(CustomerProfile customerProfile);
    Page<CustomerProfile> findCustomerProfileByName(String name, Pageable pageable);

}
