package com.arpit.question1;

import com.arpit.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This class demonstrates the delete operation on a Customer object using Hibernate.
 */
public class DeleteOperation {

    public static void main(String[] args) {

        // Configuration object is created
        Configuration configuration = new Configuration();

        // Configuration object is configured with the hibernate configuration file
        Configuration configure = configuration.configure("hibernate.cfg.xml");

        // SessionFactory object is created from the Configuration object
        SessionFactory sessionFactory = configure.buildSessionFactory();

        // Session object is created from the SessionFactory object
        Session session = sessionFactory.openSession();

        // Begin transaction
        session.beginTransaction();

        // Fetch the customer with id 1 from the database
        Customer customer = session.get(Customer.class, 1);

        // Delete the customer from the database
        session.delete(customer);

        // Commit the transaction, meaning the changes are saved into the database
        session.getTransaction().commit();

        // Close the session
        session.close();

        // Close the SessionFactory
        sessionFactory.close();
    }
}