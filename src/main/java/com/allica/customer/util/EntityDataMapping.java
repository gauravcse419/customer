package com.allica.customer.util;

import com.allica.customer.entity.CustomerDetailsEntity;
import com.allica.customer.model.Customer;
import org.springframework.stereotype.Component;

/**
 * The type Entity data mapping.
 */
@Component
public class EntityDataMapping {
    /**
     * Create customer mapping customer details entity.
     *
     * @param customer the customer
     * @return the customer details entity
     */
    public CustomerDetailsEntity createCustomerMapping(Customer customer) {
        CustomerDetailsEntity customerDetailsEntity = new CustomerDetailsEntity();
        customerDetailsEntity.setFirstName(customer.getFirstName());
        customerDetailsEntity.setLastName(customer.getLastName());
        customerDetailsEntity.setDateOfBirth(customer.getDateOfBirth());
        return customerDetailsEntity;
    }
}
