package s10338.service;

import s10338.domain.Transaction;

public interface CommitService {

    public Transaction getCommitById(String username, int bookId);

    public void updateCommit(Transaction transaction);

}
