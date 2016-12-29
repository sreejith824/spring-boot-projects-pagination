package com.tcs.mmisamples.customerprofile.web;

import com.tcs.mmisamples.customerprofile.domain.CustomerProfile;
import com.tcs.mmisamples.customerprofile.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by SSasidharan on 2016/12/26.
 */

@RestController
@RequestMapping("/v1/customerprofile")
public class CustomerProfileController {

    @Autowired
    CustomerProfileService customerProfileService;

    @RequestMapping(method = {RequestMethod.GET}, produces = "application/json")
    Iterable<CustomerProfile> getCustomerProfile() {
        return customerProfileService.findAllCustomerProfiles();
    }

    @RequestMapping(value="/search", method = {RequestMethod.GET}, produces = "application/json")
    Iterable<CustomerProfile> findCustomerProfileByName(
            @RequestParam (value = "name") String name,
            Pageable pageable) {
        return customerProfileService.findCustomerProfileByName(name, pageable);
    }

    @RequestMapping(method = {RequestMethod.POST}, consumes = "application/json")
    CustomerProfile createCustomerProfile(@RequestBody CustomerProfile customerProfile) {
        CustomerProfile response = customerProfileService.saveCustomerProfile(customerProfile);
        return response;
    }
}
