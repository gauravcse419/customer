package com.allica.customer.service;

import com.allica.customer.entity.CustomerDetailsEntity;
import com.allica.customer.model.Customer;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    ResponseEntity<Long> createCustomer(Customer customer);

    ResponseEntity<CustomerDetailsEntity> getCustomerById(long id);
}
