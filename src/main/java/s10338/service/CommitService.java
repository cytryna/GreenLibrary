package s10338.service;

import s10338.domain.Lending;

public interface CommitService {

    public Lending getCommitById(String username, int bookId);

    public void updateCommit(Lending lending);

}
