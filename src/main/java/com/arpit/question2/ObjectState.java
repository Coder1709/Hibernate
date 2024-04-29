package com.arpit.question2;

package com.arpit.question1;

import com.arpit.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

/**
 * This class demonstrates the concept of Object States in Hibernate using the Customer entity.
 */
public class ObjectState {

    public static void main(String[] args) {

        // Configuration object is created
        Configuration configuration = new Configuration();

        // Configuration object is configured with the hibernate configuration file
        Configuration configure = configuration.configure("hibernate.cfg.xml");

        // SessionFactory object is created from the Configuration object
        SessionFactory sessionFactory = configure.buildSessionFactory();

        // Create a new Customer object - At this point, the customer object is in the Transient state
        Customer customer = new Customer("John Doe", LocalDate.now(), "Software Engineer", "SDE", "Nucleus");

        // Session object is created from the SessionFactory object
        Session session = sessionFactory.openSession();

        // Begin transaction
        Transaction transaction = session.beginTransaction();

        // Save the customer object - Now, the customer object is in the Persistent state
        session.save(customer);

        // Commit the transaction
        transaction.commit();

        // Close the session - Now, the customer object is in the Detached state
        session.close();

        // Close the SessionFactory
        sessionFactory.close();
    }
}