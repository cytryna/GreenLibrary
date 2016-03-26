package s10338.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int customerId;
    private String name;
    private String address;
    private String onOfOrdersMade;


    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOnOfOrdersMade() {
        return onOfOrdersMade;
    }

    public void setOnOfOrdersMade(String onOfOrdersMade) {
        this.onOfOrdersMade = onOfOrdersMade;
    }
}
