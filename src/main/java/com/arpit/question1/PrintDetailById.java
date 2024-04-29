package com.arpit.question1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.arpit.model.Customer;

/**
 * This class demonstrates the retrieval of Customer objects by their ID using Hibernate.
 * It also illustrates the difference between the 'get' and 'load' methods in Hibernate.
 */
public class PrintDetailById {

    public static void main(String[] args) {

        // Configuration object is created and configured with the hibernate configuration file
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        // SessionFactory object is created from the Configuration object
        SessionFactory sessionFactory = configure.buildSessionFactory();

        // Session object is created from the SessionFactory object
        Session session = sessionFactory.openSession();

        // Fetch the customer with id 1 from the database using the 'get' method
        // If the object does not exist in the database, the 'get' method returns null
        // The 'get' method hits the database immediately when it's called
        // It returns a fully initialized object, meaning all the properties of the object are populated at the time of loading
        Customer customer = session.get(Customer.class, 2);

        // Fetch the customer with id 2 from the database using the 'load' method
        // If the object does not exist in the database, the 'load' method throws an ObjectNotFoundException
        // The 'load' method returns a proxy by default and the database isn't hit until the proxy is first invoked
        // It returns a proxy object that is initialized on-demand, meaning the properties of the object are populated when they are accessed for the first time
        Customer customer2 = session.load(Customer.class, 3);

        // Print the names of the customers
        System.out.println("Customer 1: " + customer.getCustomerName());
        System.out.println("Customer 2: " + customer2.getCustomerName());

        // Close the session
        session.close();

        // Close the SessionFactory
        sessionFactory.close();
    }
}