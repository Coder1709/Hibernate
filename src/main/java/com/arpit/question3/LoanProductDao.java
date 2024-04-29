package com.arpit.question3;


import com.arpit.model.LoanProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LoanProductDao{

    private SessionFactory sessionFactory;

    public LoanProductDao() {
        Configuration configuration = new Configuration();
        Configuration configure = configuration.configure("hibernate.cfg.xml");
        this.sessionFactory = configure.buildSessionFactory();
    }


    public void createLoanProduct(LoanProduct loanProduct) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(loanProduct);
        transaction.commit();
        session.close();
    }


    public LoanProduct getLoanProduct(int id) {
        Session session = sessionFactory.openSession();
        LoanProduct loanProduct = session.get(LoanProduct.class, id);
        session.close();
        return loanProduct;
    }


    public void updateLoanProduct(LoanProduct loanProduct) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(loanProduct);
        transaction.commit();
        session.close();
    }


    public void deleteLoanProduct(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LoanProduct loanProduct = session.get(LoanProduct.class, id);
        if (loanProduct != null) {
            session.delete(loanProduct);
        }
        transaction.commit();
        session.close();
    }
}
