package s10338.domain.repository;

import s10338.domain.Transaction;

public interface LibraryRepository {

    public Transaction getCommitById(String username, int bookId);

    public void updateCommit(Transaction transaction);

}
