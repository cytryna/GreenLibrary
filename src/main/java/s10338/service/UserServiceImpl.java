package s10338.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s10338.domain.BookItem;
import s10338.domain.Transaction;
import s10338.domain.User;
import s10338.domain.repository.AuthorReository;
import s10338.domain.repository.BookRepository;
import s10338.domain.repository.LibraryRepository;
import s10338.domain.repository.UserRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorReository authorReository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    LibraryRepository libraryRepository;

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
    public List<Transaction> getUserCommits(String username) {
        return userRepository.getUserCommits(username);
    }

    @Override
    @Transactional
    public void commitBook(String username, BookItem book, Transaction transaction) {
        int bookId = bookRepository.addBook(book);
        //TODO-rwichrowski poprawić
        transaction.setId(transaction.getId());
        transaction.setDateFrom(Date.valueOf(LocalDate.now()));
        userRepository.addBook(transaction);
    }
}
