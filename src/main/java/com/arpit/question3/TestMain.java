package com.arpit.question3;

import com.arpit.model.LoanAgreement;
import com.arpit.model.LoanProduct;
import com.arpit.model.LoanStatus;

import java.time.LocalDate;

public class TestMain {

    public static void main(String[] args) {
        // Create loan products for loan agreements
        LoanProduct product1 = new LoanProduct();
        product1.setProductName("Personal Loan");

        LoanProduct product2 = new LoanProduct();
        product2.setProductName("Home Loan");

        // Create an instance of LoanProductDao and LoanAgreementDao
        LoanProductDao productDao = new LoanProductDao();
        LoanAgreementDao agreementDao = new LoanAgreementDao();

        // Create operation for loan product 1
        productDao.createLoanProduct(product1);
        System.out.println("Loan Product 1 created");

        // Create operation for loan product 2
        productDao.createLoanProduct(product2);
        System.out.println("Loan Product 2 created");

        // Create loan agreements
        LoanAgreement loanAgreement1 = new LoanAgreement();
        loanAgreement1.setLoanProduct(product1);
        loanAgreement1.setLoanAmount(10000.0);
        loanAgreement1.setTenure(12);
        loanAgreement1.setRoi(8.5);
        loanAgreement1.setLoanStatus(LoanStatus.ACTIVE);
        loanAgreement1.setEmiPerMonth(950.0);
        loanAgreement1.setLoanDisbursalDate(LocalDate.now());
        loanAgreement1.setRepaymentFrequency(1);

        LoanAgreement loanAgreement2 = new LoanAgreement();
        loanAgreement2.setLoanProduct(product2);
        loanAgreement2.setLoanAmount(15000.0);
        loanAgreement2.setTenure(24);
        loanAgreement2.setRoi(9.0);
        loanAgreement2.setLoanStatus(LoanStatus.ACTIVE);
        loanAgreement2.setEmiPerMonth(800.0);
        loanAgreement2.setLoanDisbursalDate(LocalDate.now());
        loanAgreement2.setRepaymentFrequency(1);

        // Create operation for loan agreement 1
        agreementDao.createLoanAgreement(loanAgreement1);
        System.out.println("Loan Agreement 1 created");

        // Create operation for loan agreement 2
        agreementDao.createLoanAgreement(loanAgreement2);
        System.out.println("Loan Agreement 2 created");

        // Read operation to verify if they are inserted successfully
        LoanAgreement retrievedLoanAgreement1 = agreementDao.getLoanAgreement(loanAgreement1.getLoanAgreementId());
        System.out.println("Retrieved Loan Agreement 1: " + retrievedLoanAgreement1);

        LoanAgreement retrievedLoanAgreement2 = agreementDao.getLoanAgreement(loanAgreement2.getLoanAgreementId());
        System.out.println("Retrieved Loan Agreement 2: " + retrievedLoanAgreement2);

        // Update operation
        retrievedLoanAgreement1.setLoanAmount(12000.0);
        agreementDao.updateLoanAgreement(retrievedLoanAgreement1);
        System.out.println("Loan Agreement 1 updated");

        // Read operation to verify if update is successful
        LoanAgreement updatedLoanAgreement1 = agreementDao.getLoanAgreement(loanAgreement1.getLoanAgreementId());
        System.out.println("Updated Loan Agreement 1: " + updatedLoanAgreement1);

        // Delete operation
        agreementDao.deleteLoanAgreement(loanAgreement2.getLoanAgreementId());
        System.out.println("Loan Agreement 2 deleted");

    }
}
