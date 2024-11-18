package com.vsu.by.customermicro.repository;

import com.vsu.by.customermicro.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByCustomerName(String customerName);
}
