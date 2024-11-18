package com.vsu.by.customermicro.service;


import com.vsu.by.customermicro.dto.request.CreateCustomerRequest;
import com.vsu.by.customermicro.dto.request.UpdateCustomerRequest;
import com.vsu.by.customermicro.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest);

    CustomerResponse updateCustomer(Long id, UpdateCustomerRequest updateCustomerRequest);

    void deleteCustomer(Long id);

    CustomerResponse getCustomerById(Long id);

    List<CustomerResponse> getAllCustomers();
}
