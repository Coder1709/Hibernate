package com.arpit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loan_product_17254_arpit")
public class LoanProduct {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private int producId;

    private String productName;

    public LoanProduct() {
    }

    public LoanProduct(int producId, String productName) {
        this.producId = producId;
        this.productName = productName;
    }

    public int getProducId() {
        return producId;
    }

    public void setProducId(int producId) {
        this.producId = producId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "LoanProduct{" +
                "producId=" + producId +
                ", productName='" + productName + '\'' +
                '}';
    }
}
