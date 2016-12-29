package com.tcs.mmisamples.customerprofile.dao;

import com.tcs.mmisamples.customerprofile.domain.CustomerProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by SSasidharan on 2016/12/26.
 */
@Repository
public interface CustomerProfileRepository extends CrudRepository<CustomerProfile, Integer> {
}
