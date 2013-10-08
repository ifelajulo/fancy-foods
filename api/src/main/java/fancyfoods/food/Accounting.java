package fancyfoods.food;

import java.util.List;

public interface Accounting {

    /**
     * List all customers known to this accounting department.
     * 
     * @return list of customers
     */
    List<Customer> getCustomers();

    Customer getCustomer(String name);

    void chargeToAccount(String name, double purchaseAmount);

}
