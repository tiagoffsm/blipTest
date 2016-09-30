package com.blipTest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Tiago Matos on 28/09/2016.
 */

@Entity
public class Details {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Details(String description, int quantity, double value) {

        super();
        this.description = description;
        this.quantity = quantity;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", value=" + value +
                '}';
    }

    public Details() {
    }

    private String description;
    private int quantity;
    private double value;
}
