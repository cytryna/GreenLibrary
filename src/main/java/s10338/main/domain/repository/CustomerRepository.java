package s10338.main.domain.repository;

import org.springframework.stereotype.Repository;
import s10338.main.domain.Customer;

import java.util.List;


public interface CustomerRepository {

    List<Customer> getAllCustomers();

}
