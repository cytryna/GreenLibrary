package s10338.main.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import s10338.main.domain.Customer;
import s10338.main.domain.repository.CustomerRepository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {


//    @Autowired
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
//    @PersistenceContext(unitName = "myDatabase")
    private EntityManager em;

    public CustomerRepositoryImpl() {
        em = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<Customer> getAllCustomers() {
        Query query = em.createQuery("SELECT e FROM Customer e");
        return (List<Customer>) query.getResultList();
    }
}
