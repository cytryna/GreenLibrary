package s10338.domain.repository.impl;

import org.springframework.stereotype.Repository;
import s10338.domain.Lending;
import s10338.domain.repository.LibraryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Lending getCommitById(String username, int bookId) {
        //TODO-rwichrowski poprawić
        return entityManager.find(Lending.class, bookId);
    }

    @Override
    public void updateCommit(Lending lending) {
        entityManager.merge(lending);
    }
}
