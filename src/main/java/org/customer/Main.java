package org.customer;

import org.customer.controller.CustomerController;
import org.customer.repository.CustomerRepository;
import org.customer.service.CustomerService;

/**
 * Class org.customer.Main
 * author Igor Novikov
 * 23.08.24
 */

public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        CustomerService customerService       = new CustomerService(customerRepository);
        CustomerController customerController = new CustomerController(customerService);
        customerController.getCustomer(2);                                           // Select One User
        customerController.getCustomers();                                                      // All Users
    }
}
