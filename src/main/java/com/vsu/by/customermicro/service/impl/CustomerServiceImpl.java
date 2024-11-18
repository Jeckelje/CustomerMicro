package com.vsu.by.customermicro.service.impl;

import com.vsu.by.customermicro.domain.Customer;
import com.vsu.by.customermicro.dto.request.CreateCustomerRequest;
import com.vsu.by.customermicro.dto.request.UpdateCustomerRequest;
import com.vsu.by.customermicro.dto.response.CustomerResponse;
import com.vsu.by.customermicro.error.ErrorMessages;
import com.vsu.by.customermicro.exception.DuplicateResourceException;
import com.vsu.by.customermicro.exception.ResourceNotFoundException;
import com.vsu.by.customermicro.mapper.CustomerMapper;
import com.vsu.by.customermicro.repository.CustomerRepository;
import com.vsu.by.customermicro.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {
        checkCustomerExistence(createCustomerRequest.customerName());

        Customer customer = customerMapper.toCustomer(createCustomerRequest);
        return customerMapper.toCustomerResponse(customerRepository.save(customer));
    }

    @Override
    public CustomerResponse updateCustomer(Long id, UpdateCustomerRequest updateCustomerRequest) {
        Customer existingCustomer = findCustomerByIdOrThrow(id);
        customerMapper.updateCustomerFromRequest(updateCustomerRequest, existingCustomer);

        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return customerMapper.toCustomerResponse(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = findCustomerByIdOrThrow(id);
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerResponse getCustomerById(Long id) {
        Customer customer=findCustomerByIdOrThrow(id);
        return customerMapper.toCustomerResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toCustomerResponse)
                .toList();
    }


    //-----------------------------------------------------------------------------------------------------------------------------

    private Customer findCustomerByIdOrThrow(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(ErrorMessages.RESOURCE_NOT_FOUND_MESSAGE, "Customer", id)));
    }

    private void checkCustomerExistence(String name) {
        if (customerRepository.existsByCustomerName(name)) {
            throw new DuplicateResourceException(String.format(ErrorMessages.DUPLICATE_RESOURCE_MESSAGE, "Customer", "customerName"));
        }
    }
}