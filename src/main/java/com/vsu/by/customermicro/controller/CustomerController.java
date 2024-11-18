package com.vsu.by.customermicro.controller;

import com.vsu.by.customermicro.dto.request.CreateCustomerRequest;
import com.vsu.by.customermicro.dto.request.UpdateCustomerRequest;
import com.vsu.by.customermicro.dto.response.CustomerResponse;
import com.vsu.by.customermicro.service.CustomerService;
import com.vsu.by.customermicro.swagger.CustomerApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/customer")
public class CustomerController implements CustomerApi {

    private final CustomerService customerService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public CustomerResponse createCustomer(@RequestBody @Valid CreateCustomerRequest createCustomerRequest) {
        return customerService.createCustomer(createCustomerRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public CustomerResponse updateCustomer(
            @PathVariable Long id,
            @RequestBody @Valid UpdateCustomerRequest updateCustomerRequest) {
        return customerService.updateCustomer(id, updateCustomerRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public CustomerResponse getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}

