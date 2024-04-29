package com.arpit.question1;

import com.arpit.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

/**
 * This class demonstrates the creation of Customer objects and saving them into a database using Hibernate.
 */
public class InsertOperation {

    public static void main(String[] args) {



        // Customer 1
        Customer customer1 = new Customer("Alice", LocalDate.of(1990, 5, 15), "Engineer", "Senior Engineer", "ABC Company");
        // Customer 2
        Customer customer2 = new Customer("Bob", LocalDate.of(1985, 8, 20), "Doctor", "Surgeon", "XYZ Hospital");
        // Customer 3
        Customer customer3 = new Customer("Charlie", LocalDate.of(1988, 10, 30), "Artist", "Painter", "Art Studio");
        // Customer 4
        Customer customer4 = new Customer("David", LocalDate.of(1992, 3, 25), "Teacher", "Math Teacher", "123 School");
        // Customer 5
        Customer customer5 = new Customer("Emily", LocalDate.of(1982, 7, 12), "Lawyer", "Senior Lawyer", "Law Firm A");
        // Customer 6
        Customer customer6 = new Customer("Frank", LocalDate.of(1979, 9, 5), "Accountant", "CPA", "Financial Services Ltd.");
        // Customer 7
        Customer customer7 = new Customer("Grace", LocalDate.of(1995, 12, 8), "Chef", "Executive Chef", "Gourmet Restaurant");
        // Customer 8
        Customer customer8 = new Customer("Henry", LocalDate.of(1987, 4, 18), "Architect", "Principal Architect", "Architecture Firm B");
        // Customer 9
        Customer customer9 = new Customer("Ivy", LocalDate.of(1998, 6, 22), "Journalist", "Investigative Journalist", "News Agency C");
        // Customer 10
        Customer customer10 = new Customer("Jack", LocalDate.of(1980, 1, 10), "Entrepreneur", "Founder/CEO", "Startup Inc.");

        // Configuration object is created and configured with the hibernate configuration file
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        // SessionFactory object is created from the Configuration object
        SessionFactory sessionFactory = configure.buildSessionFactory();

        // Session object is created from the SessionFactory object
        Session session = sessionFactory.openSession();

        // Transaction object is created from the Session object
        Transaction transaction = session.beginTransaction();

        // Each Customer object is saved into the database
        session.save(customer1);
        session.save(customer2);
        session.save(customer3);
        session.save(customer4);
        session.save(customer5);
        session.save(customer6);
        session.save(customer7);
        session.save(customer8);
        session.save(customer9);
        session.save(customer10);

        // Transaction is committed, meaning the changes are saved into the database
        transaction.commit();
        // Session is closed
        session.close();
    }
}