package com.arpit.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "loan_agreement_17254_arpit")
public class LoanAgreement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int loanAgreementId;

    @OneToOne
    private LoanProduct loanProduct;
    private double loanAmount;
    private int tenure;
    private double roi;
    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;
    private double emiPerMonth;
    private LocalDate loanDisbursalDate;
    private int repaymentFrequency;

    public LoanAgreement() {
    }

    // Constructor


    public LoanAgreement(int loanAgreementId, LoanProduct loanProduct, double loanAmount, int tenure, double roi, LoanStatus loanStatus, double emiPerMonth, LocalDate loanDisbursalDate, int repaymentFrequency) {
        this.loanAgreementId = loanAgreementId;
        this.loanProduct = loanProduct;
        this.loanAmount = loanAmount;
        this.tenure = tenure;
        this.roi = roi;
        this.loanStatus = loanStatus;
        this.emiPerMonth = emiPerMonth;
        this.loanDisbursalDate = loanDisbursalDate;
        this.repaymentFrequency = repaymentFrequency;
    }



    // Getters and setters

    public int getLoanAgreementId() {
        return loanAgreementId;
    }

    public void setLoanAgreementId(int loanAgreementId) {
        this.loanAgreementId = loanAgreementId;
    }

    public LoanProduct getLoanProduct() {
        return loanProduct;
    }

    public void setLoanProduct(LoanProduct loanProduct) {
        this.loanProduct = loanProduct;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }

    public double getEmiPerMonth() {
        return emiPerMonth;
    }

    public void setEmiPerMonth(double emiPerMonth) {
        this.emiPerMonth = emiPerMonth;
    }

    public LocalDate getLoanDisbursalDate() {
        return loanDisbursalDate;
    }

    public void setLoanDisbursalDate(LocalDate loanDisbursalDate) {
        this.loanDisbursalDate = loanDisbursalDate;
    }

    public int getRepaymentFrequency() {
        return repaymentFrequency;
    }

    public void setRepaymentFrequency(int repaymentFrequency) {
        this.repaymentFrequency = repaymentFrequency;
    }

    // toString method

    @Override
    public String toString() {
        return "LoanAgreement{" +
                "loanAgreementId=" + loanAgreementId +
                ", loanProduct=" + loanProduct +
                ", loanAmount=" + loanAmount +
                ", tenure=" + tenure +
                ", roi=" + roi +
                ", loanStatus=" + loanStatus +
                ", emiPerMonth=" + emiPerMonth +
                ", loanDisbursalDate=" + loanDisbursalDate +
                ", repaymentFrequency=" + repaymentFrequency +
                '}';
    }
    // Method to calculate EMI
    public void calculateEMI() {
        double principal = this.loanAmount;
        double rate = this.roi / (12 * 100); // monthly rate
        double emi = (principal * rate * Math.pow(1 + rate, this.tenure)) / (Math.pow(1 + rate, this.tenure) - 1);
        this.emiPerMonth = emi;
        System.out.println("EMI per month = " + emi);
    }

    // Method to generate repayment schedule
    public void generateRepaymentSchedule() {
        LocalDate dueDate = this.loanDisbursalDate.plusMonths(1);
        for (int i = 0; i < this.tenure; i++) {
            System.out.println("Installment " + (i + 1) + ": Due date = " + dueDate + ", Amount = " + this.emiPerMonth);
            dueDate = dueDate.plusMonths(1);
        }
    }

    // Method to calculate late penalty
    public double calculateLatePenalty(LocalDate currentDate) {
        LocalDate dueDate = this.loanDisbursalDate.plusMonths(1);
        int daysLate = Period.between(dueDate, currentDate).getDays();
        if (daysLate > 0) {
            return this.emiPerMonth * 100 * daysLate; // 1% per day
        } else {
            return 0.0;
        }

    }

    // Method to calculate loan-to-value ratio
    public double calculateLoanToValueRatio() {
        double propertyValue = 1000000.0; // Assume a fixed property value
        return this.loanAmount / propertyValue;
    }

}

