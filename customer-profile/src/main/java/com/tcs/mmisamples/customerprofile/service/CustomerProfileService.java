package com.tcs.mmisamples.customerprofile.service;

import com.tcs.mmisamples.customerprofile.domain.Account;
import com.tcs.mmisamples.customerprofile.domain.AccountDetails;
import com.tcs.mmisamples.customerprofile.domain.CustomerProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by SSasidharan on 2016/12/26.
 * Spring service class to expose business service required or customer profile module.
 */
@Service
public interface CustomerProfileService {
    /**
     * API method to return all Customerprofiles in the system with pagination.
     * @param pageable
     * @return
     */
    Iterable<CustomerProfile> findAllCustomerProfiles(Pageable pageable);

    /**
     * API method to create a Customerprofile.
     * @param customerProfile
     * @return
     */
    CustomerProfile saveCustomerProfile(CustomerProfile customerProfile);

    /**
     * API method to return Customerprofiles with given name in the system with pagination.
     * @param name
     * @param pageable
     * @return
     */
    Page<CustomerProfile> findCustomerProfileByName(String name, Pageable pageable);

    Iterable<Account> findAllAccounts();

    Iterable<Account> findAccountsForCustomer(int customerId);

    List<AccountDetails> findAccountDetails(int customerId);

    List<AccountDetails> findAccountDetailsSearch(Optional<String> name, Optional<String> status, Optional<String> type);

}
