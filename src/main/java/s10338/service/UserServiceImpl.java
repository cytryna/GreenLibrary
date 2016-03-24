package s10338.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s10338.domain.Book;
import s10338.domain.Commit;
import s10338.domain.User;
import s10338.domain.dao.AuthorDao;
import s10338.domain.dao.BookDao;
import s10338.domain.dao.CommitDao;
import s10338.domain.dao.UserDao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    AuthorDao authorDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    CommitDao commitDao;

    @Override
    @Transactional
    public void addUser(User user) {

    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    @Transactional
    public void updateUser(User user) {

    }

    @Override
    @Transactional
    public void removeUser(String username) {

    }

    @Override
    @Transactional
    public List<Commit> getUserCommits(String username) {
        return userDao.getUserCommits(username);
    }

    @Override
    @Transactional
    public void commitBook(String username, Book book, Commit commit) {
        int bookId = bookDao.addBook(book);
        commit.setCommitKey(new Commit.CommitKey(username, bookId));
        commit.setDate(Date.valueOf(LocalDate.now()));
        userDao.addBook(commit);
    }
}
