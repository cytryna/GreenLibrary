package s10338.domain.repository.impl;

import org.springframework.stereotype.Repository;
import s10338.domain.Transaction;
import s10338.domain.repository.LibraryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Transaction getCommitById(String username, int bookId) {
        //TODO-rwichrowski poprawić
        return entityManager.find(Transaction.class, bookId);
    }

    @Override
    public void updateCommit(Transaction transaction) {
        entityManager.merge(transaction);
    }
}
