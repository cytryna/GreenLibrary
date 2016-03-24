package s10338.service;

import s10338.domain.Commit;

public interface CommitService {

    public Commit getCommitById(String username, int bookId);

    public void updateCommit(Commit commit);

}
