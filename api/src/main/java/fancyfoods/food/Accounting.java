package fancyfoods.food;

import java.math.BigDecimal;
import java.util.List;

public interface Accounting {

    Customer getCustomer(String name);

    void chargeToAccount(String name, double purchaseAmount);

    /**
     * List all customers known to this accounting department.
     * 
     * @return list of customers
     */
    List<Customer> getCustomers();

    /**
     * Register a new customer in this department.
     * 
     * @param name the name of the customer
     * @param balance the initial account balance
     * @param creditLimit the account maximum debt
     */
    void registerCustomer(String name, BigDecimal balance, BigDecimal creditLimit);

}
