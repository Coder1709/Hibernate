package com.arpit.presentation;

import com.arpit.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Question1 {

    public static void main(String[] args) {


        // Generate 10 different Customer objects
        Customer customer1 = new Customer("Alice", LocalDate.of(1990, 5, 15), "Engineer", "Senior Engineer", "ABC Company");
        Customer customer2 = new Customer("Bob", LocalDate.of(1985, 8, 20), "Doctor", "Surgeon", "XYZ Hospital");
        Customer customer3 = new Customer("Charlie", LocalDate.of(1988, 10, 30), "Artist", "Painter", "Art Studio");
        Customer customer4 = new Customer("David", LocalDate.of(1992, 3, 25), "Teacher", "Math Teacher", "123 School");
        Customer customer5 = new Customer("Emily", LocalDate.of(1982, 7, 12), "Lawyer", "Senior Lawyer", "Law Firm A");
        Customer customer6 = new Customer("Frank", LocalDate.of(1979, 9, 5), "Accountant", "CPA", "Financial Services Ltd.");
        Customer customer7 = new Customer("Grace", LocalDate.of(1995, 12, 8), "Chef", "Executive Chef", "Gourmet Restaurant");
        Customer customer8 = new Customer("Henry", LocalDate.of(1987, 4, 18), "Architect", "Principal Architect", "Architecture Firm B");
        Customer customer9 = new Customer("Ivy", LocalDate.of(1998, 6, 22), "Journalist", "Investigative Journalist", "News Agency C");
        Customer customer10 = new Customer("Jack", LocalDate.of(1980, 1, 10), "Entrepreneur", "Founder/CEO", "Startup Inc.");

        // You can use these Customer objects as needed

        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

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

        transaction.commit();
        session.close();





    }
}
