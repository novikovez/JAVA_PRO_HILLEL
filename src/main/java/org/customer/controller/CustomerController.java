package org.customer.controller;


import org.customer.language.Language;
import org.customer.service.CustomerService;

/**
 * Class org.customer.controller.CustomerController
 * author Igor Novikov
 * 23.08.24
 */

public class CustomerController extends Language {
    private final CustomerService customerService;

    public CustomerController(
            CustomerService customerService
    ) {
        System.out.println(Language.run);
        this.customerService = customerService;
    }

    public void getCustomer(int customerKey) {
        System.out.println(Language.one);
        System.out.println(customerService.getCustomer(customerKey));
        System.out.println(Language.line);
    }

    public void getCustomers() {
        System.out.println(Language.all);
        System.out.println(customerService.getCustomers());
    }

}
