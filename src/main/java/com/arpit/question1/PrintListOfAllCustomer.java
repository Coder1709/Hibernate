package com.arpit.question1;

import com.arpit.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This class demonstrates the retrieval of all Customer objects from the database using Hibernate.
 */
public class PrintListOfAllCustomer {

    public static void main(String[] args) {

        // Configuration object is created
        Configuration configuration = new Configuration();

        // Configuration object is configured with the hibernate configuration file
        Configuration configure = configuration.configure("hibernate.cfg.xml");

        // SessionFactory object is created from the Configuration object
        SessionFactory sessionFactory = configure.buildSessionFactory();

        // Session object is created from the SessionFactory object
        Session session = sessionFactory.openSession();

        // A Criteria object is created for Customer class, which can be used to fetch all Customer objects from the database
        // The list method is called on the Criteria object to fetch the list of all Customer objects
        // The forEach method is used to print each Customer object
        session.createCriteria(Customer.class).list().forEach(System.out::println);

        // Close the session
        session.close();

        // Close the SessionFactory
        sessionFactory.close();
    }
}