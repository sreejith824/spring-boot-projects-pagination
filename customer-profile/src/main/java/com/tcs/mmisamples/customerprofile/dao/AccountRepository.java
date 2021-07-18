package com.tcs.mmisamples.customerprofile.dao;

import com.tcs.mmisamples.customerprofile.domain.Account;
import com.tcs.mmisamples.customerprofile.domain.AccountDetails;
import com.tcs.mmisamples.customerprofile.domain.CustomerProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Created by SSasidharan on 2016/12/26.
 * Data access layer (Repository) interface with Pagination features.
 */

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {



    Iterable<Account> findAccountsByCustomerProfile(CustomerProfile customerProfile);

    @Query("SELECT new com.tcs.mmisamples.customerprofile.domain.AccountDetails(b.name, b.age, b.customerId, a.accountId, a.accountType, a.accountStatus) " +
            "FROM Account a LEFT JOIN CustomerProfile b ON a.customerProfile.customerId=b.customerId " +
            "WHERE b.customerId=:customerId")
    List<AccountDetails> findAccountDetails(@Param(value = "customerId") int customerId);


    @Query("SELECT new com.tcs.mmisamples.customerprofile.domain.AccountDetails(b.name, b.age, b.customerId, a.accountId, a.accountType, a.accountStatus) " +
            "FROM Account a LEFT JOIN CustomerProfile b ON a.customerProfile.customerId=b.customerId " +
            "WHERE b.name=:name " +
            "AND a.accountStatus=:accountStatus " +
            "AND a.accountType=:accountType")
    List<AccountDetails> findAccountDetailsSearch(
            @Param(value = "name") Optional<String> name,
            @Param(value = "accountStatus") Optional<String> accountStatus,
            @Param(value = "accountType") Optional<String> accountType
    );



}

