package s10338.service;


import s10338.domain.Book;

import java.util.List;

public interface BookService {

    int addBook(Book book);

    Book getBookById(int bookId);

    List<Book> getBookByTitle(String title);

    List<Book> getAllBooks();

    void updateBook(Book book);

    void removeBook(int bookId);

}
