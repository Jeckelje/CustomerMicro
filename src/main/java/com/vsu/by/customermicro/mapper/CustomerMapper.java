package com.vsu.by.customermicro.mapper;

import com.vsu.by.customermicro.domain.Customer;
import com.vsu.by.customermicro.dto.request.CreateCustomerRequest;
import com.vsu.by.customermicro.dto.request.UpdateCustomerRequest;
import com.vsu.by.customermicro.dto.response.CustomerResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    CustomerResponse toCustomerResponse(Customer customer);

    Customer toCustomer(CustomerResponse customerResponse);
    Customer toCustomer(CreateCustomerRequest createCustomerRequest);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer toCustomer(UpdateCustomerRequest updateCustomerRequest);

    @Mapping(target = "id", ignore = true)
    void updateCustomerFromRequest(UpdateCustomerRequest updateCustomerRequest, @MappingTarget Customer customer);
}
