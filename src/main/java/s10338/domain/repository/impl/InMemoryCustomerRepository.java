//package s10338.main.domain.repository.impl;
//
//import org.springframework.stereotype.Repository;
//import Customer;
//import CustomerRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class InMemoryCustomerRepository implements CustomerRepository {
//
//    private List<Customer> customers;
//
//    public InMemoryCustomerRepository() {
//        customers = new ArrayList<>();
//        int customerId = 0;
//        customers.add(new Customer(++customerId, "Radek", "Warszawa"));
//        customers.add(new Customer(++customerId, "Jacek", "Radom"));
//        customers.add(new Customer(++customerId, "Monika", "Warszawa"));
//        customers.add(new Customer(++customerId, "Weronika"));
//        customers.add(new Customer(++customerId, "Oliwia", "Warszawa"));
//        customers.add(new Customer(++customerId, "Marta"));
//    }
//
//    @Override
//    public List<Customer> getAllCustomers() {
//        return customers;
//    }
//}
