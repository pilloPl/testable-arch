package io.pillopl.testablearch.ex2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    Customer() {
    }

    Customer(Long id, String name, int numberOfRentals) {
        this.id = id;
        this.name = name;
        this.numberOfRentals = numberOfRentals;
    }

    @Id
    private Long id;

    private String name;

    private int numberOfRentals;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getNumberOfRentals() {
        return numberOfRentals;
    }

    public void setNumberOfRentals(int numberOfRentals) {
        this.numberOfRentals = numberOfRentals;
    }


    public boolean rentACar() {
        if(numberOfRentals < 3) {
            numberOfRentals++;
            return true;
        }
        return false;
    }
}
