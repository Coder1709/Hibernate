package com.arpit.question3;


import com.arpit.model.LoanAgreement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LoanAgreementDao {

    private SessionFactory sessionFactory;

    public LoanAgreementDao() {
        Configuration configuration = new Configuration();
        Configuration configure = configuration.configure("hibernate.cfg.xml");
        this.sessionFactory = configure.buildSessionFactory();
    }

    // Create operation
    public void createLoanAgreement(LoanAgreement loanAgreement) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(loanAgreement);
        transaction.commit();
        session.close();
    }

    // Read operation
    public LoanAgreement getLoanAgreement(int id) {
        Session session = sessionFactory.openSession();
        LoanAgreement loanAgreement = session.get(LoanAgreement.class, id);
        session.close();
        return loanAgreement;
    }

    // Update operation
    public void updateLoanAgreement(LoanAgreement loanAgreement) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(loanAgreement);
        transaction.commit();
        session.close();
    }

    // Delete operation
    public void deleteLoanAgreement(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LoanAgreement loanAgreement = session.get(LoanAgreement.class, id);
        if (loanAgreement != null) {
            session.delete(loanAgreement);
        }
        transaction.commit();
        session.close();
    }
}