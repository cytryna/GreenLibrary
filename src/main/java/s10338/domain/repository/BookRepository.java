package s10338.domain.repository;


import s10338.domain.Book;

import java.util.List;

public interface BookRepository {

    int addBook(Book book);

    Book getBookById(int bookId);

    Book getConcreteBookByTitle(String title);

    List<Book> getAllBooks();

    void updateTransaction(Book book);

    void removeBook(int bookId);

    List<Book> getBookByTitle(String title);

}
