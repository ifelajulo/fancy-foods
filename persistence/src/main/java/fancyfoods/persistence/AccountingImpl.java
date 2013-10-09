package fancyfoods.persistence;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fancyfoods.food.Accounting;
import fancyfoods.food.Customer;

// TODO Rename to JpaAccounting or PersistentAccounting.
public class AccountingImpl implements Accounting {

    private Logger logger = LoggerFactory.getLogger(AccountingImpl.class);

    private EntityManager em;

    // TODO Change to constructor injection if possible with Blueprint.
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public void chargeToAccount(String name, double purchaseAmount) {
        CustomerImpl customer = getCustomer(name);
        if (customer == null) {
            customer = new CustomerImpl();
            customer.setName(name);
            customer.setCreditLimit(20);
            em.persist(customer);
        }
        double currentLevel = customer.getBalance();
        double creditLimit = customer.getCreditLimit();
        double newBalance = currentLevel + purchaseAmount;
        if (newBalance <= creditLimit) {
            customer.setBalance(newBalance);
            em.persist(customer);
        } else {
            throw new IllegalArgumentException("$" + customer.getCreditLimit() + " is not enough credit for a $"
                    + newBalance + " purchase.");
        }
    }

    @Override
    public CustomerImpl getCustomer(String name) {
        return em.find(CustomerImpl.class, name);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> getCustomers() {
        return em.createQuery("SELECT c FROM CUSTOMER c").getResultList();
    }

    @Override
    public void registerCustomer(String name, BigDecimal balance, BigDecimal creditLimit) {
        logger.info("Registering new customer [{}] with initial balance of ${} and credit ${}", name, balance,
                creditLimit);
        CustomerImpl customerImpl = new CustomerImpl();
        customerImpl.setName(name);
        customerImpl.setBalance(balance.doubleValue());
        customerImpl.setCreditLimit(creditLimit.doubleValue());
        em.persist(customerImpl);
    }

}
