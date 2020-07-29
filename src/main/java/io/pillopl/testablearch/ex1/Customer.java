package io.pillopl.testablearch.ex1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private Long id;

    private String name;

    private int numberOfRentals;

    Customer() {
    }

    Customer(Long id, String name, int numberOfRentals) {
        this.id = id;
        this.name = name;
        this.numberOfRentals = numberOfRentals;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfRentals(int numberOfRentals) {
        this.numberOfRentals = numberOfRentals;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public int getNumberOfRentals() {
        return numberOfRentals;
    }

}
