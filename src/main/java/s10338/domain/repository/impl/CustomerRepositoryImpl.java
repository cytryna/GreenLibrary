package s10338.domain.repository.impl;

import org.springframework.stereotype.Repository;
import s10338.domain.Customer;
import s10338.domain.repository.CustomerRepository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {


    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> getAllCustomers() {
        Query query = em.createQuery("SELECT e FROM Customer e");
        return (List<Customer>) query.getResultList();
    }
}
