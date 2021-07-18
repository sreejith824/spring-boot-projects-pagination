package com.tcs.mmisamples.customerprofile.web;

import com.tcs.mmisamples.customerprofile.domain.Account;
import com.tcs.mmisamples.customerprofile.domain.AccountDetails;
import com.tcs.mmisamples.customerprofile.domain.CustomerProfile;
import com.tcs.mmisamples.customerprofile.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by SSasidharan on 2016/12/26.
 * Spring Controller class responsible for exposing REST APIs.
 */

@RestController
@RequestMapping("/v1/accountdetails")
public class AccountDetailsController {

    @Autowired
    CustomerProfileService customerProfileService;
    @RequestMapping(value="/search", method = {RequestMethod.GET}, produces = "application/json")
    List<AccountDetails> findAccountDetailsSearch(
            @RequestParam (value = "name") Optional<String> name,
            @RequestParam (value = "status") Optional<String> status,
            @RequestParam (value = "type") Optional<String> type) {
        return customerProfileService.findAccountDetailsSearch(name, status, type);
    }

    @RequestMapping(value="/{customerId}", method = {RequestMethod.GET}, produces = "application/json")
    List<AccountDetails> findAccountDetails(@PathVariable (value = "customerId") String customerId) {
        return customerProfileService.findAccountDetails(Integer.valueOf(customerId));
    }



}
