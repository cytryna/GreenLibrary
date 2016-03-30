package s10338.domain.repository.impl;

import org.springframework.stereotype.Repository;
import s10338.domain.Transaction;
import s10338.domain.User;
import s10338.domain.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {

    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void removeUser(String username) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Transaction> getUserCommits(String username) {
        try {
            User user = entityManager.find(User.class, username);
            List<Transaction> libraries = user.getTransactions();
            libraries.size();
            return libraries;
        } catch (PersistenceException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void addBook(Transaction transaction) {
        try {
            entityManager.persist(transaction);
        } catch (PersistenceException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
