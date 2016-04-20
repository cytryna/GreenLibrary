package s10338.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s10338.domain.Book;
import s10338.domain.Transaction;
import s10338.domain.repository.BookRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by max on 04.02.15.
 */
@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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
    public List<Book> getBookByTitle(String title) {
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
    public void reservationBook(Book book) {
        Transaction transaction = new Transaction(new Date(), book);

        bookRepository.updateBook(book);
    }

    @Override
    @Transactional
    public void removeBook(int bookId) {
        bookRepository.removeBook(bookId);
    }
}
