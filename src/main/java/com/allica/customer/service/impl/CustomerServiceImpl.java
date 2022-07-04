package com.allica.customer.service.impl;

import com.allica.customer.Exception.CustomerNotFoundException;
import com.allica.customer.entity.CustomerDetailsEntity;
import com.allica.customer.model.Customer;
import com.allica.customer.repository.CustomerRepository;
import com.allica.customer.service.CustomerService;
import com.allica.customer.util.EntityDataMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type Customer service.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    /**
     * The Customer repository.
     */
    @Autowired
    CustomerRepository customerRepository;

    /**
     * The Entity data mapping.
     */
    @Autowired
    EntityDataMapping entityDataMapping;

    @Override
    public ResponseEntity<Long> createCustomer(Customer customer) {
        try {
            CustomerDetailsEntity requestEntity=entityDataMapping.createCustomerMapping(customer);
            CustomerDetailsEntity entityResponse= customerRepository
                    .save(requestEntity);
            return new ResponseEntity<>(entityResponse.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<CustomerDetailsEntity> getCustomerById(long id) {
        Optional<CustomerDetailsEntity> customerData = customerRepository.findById(id);
        if (customerData.isPresent()) {
            return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
        } else {
           throw new CustomerNotFoundException(id);
        }
    }
}
