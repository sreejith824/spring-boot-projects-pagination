package com.tcs.mmisamples.customerprofile.service.impl;

import com.tcs.mmisamples.customerprofile.dao.AccountRepository;
import com.tcs.mmisamples.customerprofile.dao.AccountRepositoryImpl;
import com.tcs.mmisamples.customerprofile.dao.CustomerProfilePaginationRepository;
import com.tcs.mmisamples.customerprofile.domain.Account;
import com.tcs.mmisamples.customerprofile.domain.AccountDetails;
import com.tcs.mmisamples.customerprofile.domain.CustomerProfile;
import com.tcs.mmisamples.customerprofile.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by SSasidharan on 2016/12/26.
 * Spring Service implementation class for Customer profile module.
 */
@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    @Autowired
    CustomerProfilePaginationRepository customerProfilePaginationRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountRepositoryImpl accountRepositoryImpl;



    public CustomerProfileServiceImpl() {

    }

    @PostConstruct
    public void loadData() {
        CustomerProfile customerProfile = null;
        Account account = null;
        for (int i=0 ; i < 100; i++) {
            customerProfile = new CustomerProfile("Name-" + i, i + 20);
            customerProfile.setEmail(customerProfile.getName() + "@test.com");
            customerProfile = saveCustomerProfile(customerProfile);
            for (int j=0 ; j < 5; j++) {
                account = new Account(customerProfile, "savings");
                account.setAccountStatus("new");
                accountRepository.save(account);
            }
            for (int j=0 ; j < 5; j++) {
                account = new Account(customerProfile, "current");
                account.setAccountStatus("active");
                accountRepository.save(account);
            }
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

    @Override
    public Iterable<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Iterable<Account> findAccountsForCustomer(int customerId) {
        CustomerProfile customerProfile = new CustomerProfile(customerId);
        return accountRepository.findAccountsByCustomerProfile(customerProfile);
    }

    @Override
    public List<AccountDetails> findAccountDetails(int customerId) {
        return accountRepository.findAccountDetails(customerId);
    }

    @Override
    public List<AccountDetails> findAccountDetailsSearch(Optional<String> name, Optional<String> status, Optional<String> type) {
        //return accountRepository.findAccountDetailsSearch(name, status, type);
        return accountRepositoryImpl.findAccountDetailsDynamicSearch(name, status, type);

    }

}
