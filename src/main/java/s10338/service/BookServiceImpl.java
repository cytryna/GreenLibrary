package s10338.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s10338.domain.Book;
import s10338.domain.Transaction;
import s10338.domain.TransactionType;
import s10338.domain.User;
import s10338.domain.repository.BookRepository;
import s10338.domain.repository.UserRepository;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;
    UserRepository userRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public int addBook(Book book) {
        return bookRepository.addBook(book);
    }

    @Override
    @Transactional
    public Book getBookById(int bookId) {
        return bookRepository.getBookById(bookId);
    }

    @Override
    public Book getConcreteBookByTitle(String title) {
        return bookRepository.getConcreteBookByTitle(title);
    }

    @Override
    public List<Book> getBooksLikeTitle(String title) {
        return bookRepository.getBookByTitle(title);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    @Override
    @Transactional
    public void removeBook(int bookId) {
        bookRepository.removeBook(bookId);
    }

    @Override
    public void reservation(int bookId, int userId) {
        Book bookById = bookRepository.getBookById(bookId);
        User user = userRepository.getUserById(userId);
        Transaction transaction = new Transaction(new Date(), bookById, user, TransactionType.RESERVATION);
        bookById.getTransaction().add(transaction);
        bookRepository.updateBook(bookById);
    }
}
