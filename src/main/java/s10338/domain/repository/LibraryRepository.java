package s10338.domain.repository;

import s10338.domain.Lending;

public interface LibraryRepository {

    public Lending getCommitById(String username, int bookId);

    public void updateCommit(Lending lending);

}
