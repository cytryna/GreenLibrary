package s10338.domain.dao;

import org.springframework.stereotype.Repository;
import s10338.domain.Commit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaCommitDao implements CommitDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Commit getCommitById(String username, int bookId) {
        return entityManager.find(Commit.class, new Commit.CommitKey(username, bookId));
    }

    @Override
    public void updateCommit(Commit commit) {
        entityManager.merge(commit);
    }
}
