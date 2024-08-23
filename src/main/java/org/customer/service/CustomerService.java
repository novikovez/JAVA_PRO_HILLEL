package org.customer.service;


import org.customer.language.Language;
import org.customer.repository.CustomerRepository;

/**
 * Class org.customer.service.CustomerService
 * author Igor Novikov
 * 23.08.24
 */

public class CustomerService extends Language {
    private final CustomerRepository customerRepository;

    public CustomerService(
            CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    public String getCustomer(int customerId) {
        String[] customer = this.customerRepository.userData()[customerId];
        return Language.customer + customer[0] + Language.phone + customer[1];
    }

    public String getCustomers() {
        StringBuilder result = new StringBuilder();

        for(String[] customer : this.customerRepository.userData()) {
            result.append(Language.customer)
                    .append(customer[0])
                    .append(Language.phone)
                    .append(customer[1])
                    .append("\n");;
        }

        return result.toString();
    }


}
