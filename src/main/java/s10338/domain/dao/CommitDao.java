package s10338.domain.dao;

import s10338.domain.Commit;

public interface CommitDao {

    public Commit getCommitById(String username, int bookId);

    public void updateCommit(Commit commit);

}
