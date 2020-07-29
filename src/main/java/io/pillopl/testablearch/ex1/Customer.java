package io.pillopl.testablearch.ex1;

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


    public String getName() {
        return name;
    }

    public int getNumberOfRentals() {
        return numberOfRentals;
    }

    public boolean rentACar() {
        if (numberOfRentals < 3) {
            numberOfRentals++;
            return true;
        }
        return false;
    }
}
