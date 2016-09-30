package com.blipTest.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Tiago Matos on 28/09/2016.
 */

@Entity
public class Purchase {

    public Purchase(String productType, Timestamp expires, Details purchaseDetails) {
        super();
        this.productType = productType;
        this.expires = expires;
        this.purchaseDetails = purchaseDetails;
    }

    public Purchase() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Timestamp expires) {
        this.expires = expires;
    }

    public Details getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(Details purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String productType;
    private Timestamp expires;
    @OneToOne
    @JoinColumn(name = "id")
    private Details purchaseDetails;

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", productType='" + productType + '\'' +
                ", expires=" + expires +
                ", purchaseDetails=" + purchaseDetails +
                '}';
    }
}
