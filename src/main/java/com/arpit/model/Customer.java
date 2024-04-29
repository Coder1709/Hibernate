package com.arpit.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer_arpit_17254")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "customer_name" , nullable = false , length = 100)
    private String customerName;

    @Column(name = "date_of_birth" )
    private LocalDate dateOfBirth;

    @Column(name = "profession" , length = 100)
    private String profession;

    @Column(name = "designation")
    private  String designation;

    @Column(name = "company_name")
    private String companyName;


    public Customer() {
    }

    public Customer( String customerName, LocalDate dateOfBirth, String profession, String designation, String companyName) {
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.profession = profession;
        this.designation = designation;
        this.companyName = companyName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", profession='" + profession + '\'' +
                ", Designation='" + designation + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
