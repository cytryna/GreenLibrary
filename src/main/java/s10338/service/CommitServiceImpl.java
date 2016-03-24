package s10338.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s10338.domain.Commit;
import s10338.domain.dao.CommitDao;

import javax.transaction.Transactional;

@Service
public class CommitServiceImpl implements CommitService {

    @Autowired
    private CommitDao commitDao;

    @Override
    @Transactional
    public Commit getCommitById(String username, int bookId) {
        return commitDao.getCommitById(username, bookId);
    }

    @Override
    @Transactional
    public void updateCommit(Commit commit) {
        commitDao.updateCommit(commit);
    }
}
