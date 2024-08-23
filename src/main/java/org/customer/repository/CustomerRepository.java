package org.customer.repository;


/**
 * Class org.customer.repository.CustomerRepository
 * author Igor Novikov
 * 23.08.24
 */

public class CustomerRepository {
    public String[][] userData() {
        String[][] stringArray = new String[3][2];
        stringArray[0][0] = "Ivan";
        stringArray[0][1] = "096-565-55-44";
        stringArray[1][0] = "Jack";
        stringArray[1][1] = "096-565-55-41";
        stringArray[2][0] = "Maria";
        stringArray[2][1] = "096-565-55-42";

        return stringArray;
    }
}
