package com.allica.customer.Exception;

/**
 * The type Customer not found exception.
 */
public class CustomerNotFoundException extends RuntimeException{
    /**
     * Instantiates a new Customer not found exception.
     *
     * @param id the id
     */
    public CustomerNotFoundException(Long id){
        super(String.format("Customer with %id not found",id));
    }
}
