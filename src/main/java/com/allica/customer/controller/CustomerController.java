package com.allica.customer.controller;

import com.allica.customer.entity.CustomerDetailsEntity;
import com.allica.customer.model.Customer;
import com.allica.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Customer controller.
 */
@RestController
@RequestMapping("/customer-service/v1")
public class CustomerController {

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    /**
     * The Customer service.
     */
    @Autowired
    CustomerService customerService;

    /**
     * Create customer int.
     *
     * @param customer the customer
     * @return the int
     */
    @PostMapping("/create/customer")
    public ResponseEntity<Long> createCustomer(@RequestBody Customer customer){
        logger.info("|CustomerController|createCustomer started--->");
        return customerService.createCustomer(customer);

    }

    /**
     * Gets customer by id.
     *
     * @param id the id
     * @return the customer by id
     */
    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDetailsEntity> getCustomerById(@PathVariable("id") long id) {
        logger.info("|CustomerController|getCustomerById started--->");
        return customerService.getCustomerById(id);
    }
}
