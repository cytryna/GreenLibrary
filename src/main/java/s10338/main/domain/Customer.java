package s10338.main.domain;

public class Customer {
    private int customerId;
    private String name;
    private String address;
    private String onOfOrdersMade;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public Customer(int customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
