package s10338.domain.repository;

import s10338.domain.Commit;

public interface LibraryRepository {

    public Commit getCommitById(String username, int bookId);

    public void updateCommit(Commit commit);

}
