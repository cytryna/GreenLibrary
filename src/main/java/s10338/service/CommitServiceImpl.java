package s10338.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s10338.domain.Transaction;
import s10338.domain.repository.LibraryRepository;

import javax.transaction.Transactional;

@Service
public class CommitServiceImpl implements CommitService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    @Transactional
    public Transaction getCommitById(String username, int bookId) {
        return libraryRepository.getCommitById(username, bookId);
    }

    @Override
    @Transactional
    public void updateCommit(Transaction transaction) {
        libraryRepository.updateCommit(transaction);
    }
}
