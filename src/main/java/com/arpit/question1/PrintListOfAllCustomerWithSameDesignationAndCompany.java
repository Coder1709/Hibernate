package com.arpit.question1;

import com.arpit.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * This class demonstrates the retrieval of all Customer objects from the database using Hibernate,
 * who have the same designation and belong to the same company.
 */
public class PrintListOfAllCustomerWithSameDesignationAndCompany {

    public static void main(String[] args) {

        // Configuration object is created
        Configuration configuration = new Configuration();

        // Configuration object is configured with the hibernate configuration file
        Configuration configure = configuration.configure("hibernate.cfg.xml");

        // SessionFactory object is created from the Configuration object
        SessionFactory sessionFactory = configure.buildSessionFactory();

        // Session object is created from the SessionFactory object
        Session session = sessionFactory.openSession();

        // A Criteria object is created for Customer class
        // Restrictions are added for the 'designation' and 'company' fields
        List<Customer> customers = session.createCriteria(Customer.class)
                .add(Restrictions.eq("designation", "YourDesignation"))
                .add(Restrictions.eq("company", "YourCompany"))
                .list();

        // The forEach method is used to print each Customer object
        customers.forEach(System.out::println);

        // Close the session
        session.close();

        // Close the SessionFactory
        sessionFactory.close();
    }
}